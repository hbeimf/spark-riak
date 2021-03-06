package SparkRiak

import org.apache.spark.{SparkContext, SparkConf}
import com.basho.riak.spark._


// https://github.com/basho/spark-riak-connector/blob/master/docs/using-connector.md#configuration-of-spark-context

object SparkRiak {
    def main(args: Array[String]): Unit = {
        val appName = "SparkRiak"

        val conf = new SparkConf()
        .setAppName(appName)
        .set("spark.riak.connection.host", "127.0.0.1:8087")
        .set("spark.riak.connections.min", "20")
        .set("spark.riak.connections.max", "50")


        var kv_bucket_name = "bucket1"

        val sc = new SparkContext("spark://127.0.0.1:7077", appName, conf)

        val rdd = sc.riakBucket[String]("bucket1").queryAll()
        rdd.collect().foreach(println)

        println("=======================")

        val rdd1 = sc.riakBucket[String](kv_bucket_name).queryBucketKeys("mine", "yours")
        rdd.collect().foreach(println)

        println("spark riak!!!")

        var new_bucket = "new_bucket"
        rdd.saveToRiak(new_bucket)

        val rddNew = sc.riakBucket[String](new_bucket).queryAll()
        rddNew.collect().foreach(println)


        // val data = Array(1, 2, 3, 4, 5)
        // val testRDD = sc.parallelize(data)
        // testRDD.saveToRiak("kv_bucket_a")

        sc.stop()
    }
}
