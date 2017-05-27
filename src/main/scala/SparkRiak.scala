package SparkRiak

// import org.apache.spark.{SparkContext, SparkConf}
// import com.basho.riak.spark._


// // https://github.com/basho/spark-riak-connector/blob/master/docs/using-connector.md#configuration-of-spark-context

// object SparkRiak {
//     def main(args: Array[String]): Unit = {
//         val appName = "SparkRiak"

//         val conf = new SparkConf()
//         .setAppName(appName)
//         .set("spark.riak.connection.host", "127.0.0.1:8087")
//         .set("spark.riak.connections.min", "20")
//         .set("spark.riak.connections.max", "50")

//         val sc = new SparkContext("spark://127.0.0.1:7077", appName, conf)

//         val rdd = sc.riakBucket[String]("bucket1").queryAll()
//         rdd.collect().foreach(println)

//         println("spark riak!!!")


//         // val data = Array(1, 2, 3, 4, 5)
//         // val testRDD = sc.parallelize(data)
//         // testRDD.saveToRiak("kv_bucket_a")

//         sc.stop()
//     }
// }



/**
 * Copyright (c) 2015 Basho Technologies, Inc.
 *
 * This file is provided to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain
 * a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
// package com.basho.riak.spark.examples.dataframes

import com.basho.riak.client.core.query.indexes.LongIntIndex
import com.basho.riak.client.core.query.Namespace
import com.basho.riak.spark._
import com.basho.riak.spark.util.RiakObjectConversionUtil
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import scala.reflect.runtime.universe
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{ Failure, Success }
import com.basho.riak.client.core.query.RiakObject
import com.basho.riak.client.api.RiakClient
import com.basho.riak.client.core.query.Location
// import com.basho.riak.spark.rdd.RiakFunctions

/**
 * Example shows how Spark DataFrames can be used with Riak
 * connector for spark
 */
// object SimpleScalaRiakDataframesExample {
object SparkRiak {
  private val bucketName = "users"

  case class UserData(user_id: String, name: String, age: Int, category: String)

  val testData = Seq(
    UserData("u1", "Ben", 23, "CategoryA"),
    UserData("u2", "Clair", 19, "CategoryB"),
    UserData("u3", "John", 21, null),
    UserData("u4", "Chris", 50, "Categoryc"),
    UserData("u5", "Mary", 15, "CategoryB"),
    UserData("u6", "George", 31, "CategoryC")
  )

  def main(args: Array[String]) {
    val sparkConf = new SparkConf().setAppName("Riak Spark Dataframes Example")

    setSparkOpt(sparkConf, "spark.master", "local")
    setSparkOpt(sparkConf, "spark.riak.connection.host", "127.0.0.1:8087")

    val sc = new SparkContext(sparkConf)

    // Work with clear bucket
    // clearBucket(sparkConf)

    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    // To enable toDF()
    import sqlContext.implicits._

    println(s" Saving data to Riak: \n ${println(testData)}")

    // Save test data from json file to riak bucket
    val inputRDD = sc.parallelize(testData).map {
      line =>
        val obj = RiakObjectConversionUtil.to(line)
        // RiakObjectConversionUtil.to() sets content type to text/plain if String is passed
        // Overwriting content type to application/json will allow automatic conversion to
        // User defined type when reading from Riak
        obj.setContentType("application/json")
        obj
    }.saveToRiak(bucketName)

    // Read from Riak with UDT to enable schema inference using reflection
    val df = sc.riakBucket[UserData](bucketName).queryAll.toDF

    println(s"Dataframe from Riak query: \n ${df.show()}")

    df.registerTempTable("users")

    println("count by category")
    df.groupBy("category").count.show

    println("sort by num of letters")
    // Register user defined function
    sqlContext.udf.register("stringLength", (s: String) => s.length)
    sqlContext.sql("select user_id, name, stringLength(name) nameLength from users order by nameLength").show

    println("filter age >= 21")
    sqlContext.sql("select * from users where age >= 21").show

  }

  // private def clearBucket(sparkConf: SparkConf): Unit = {
  //   val rf = RiakFunctions(sparkConf)
  //   rf.withRiakDo(session => {
  //     rf.resetAndEmptyBucketByName(bucketName)
  //   })
  // }

  private def setSparkOpt(sparkConf: SparkConf, option: String, defaultOptVal: String): SparkConf = {
    val optval = sparkConf.getOption(option).getOrElse(defaultOptVal)
    sparkConf.set(option, optval)
  }

}
