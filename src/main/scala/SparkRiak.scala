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
        // .set("spark.riak.connection.host", "127.0.0.1")
        .set("spark.riak.connections.min", "20")
        .set("spark.riak.connections.max", "50")

        
        val sc = new SparkContext("spark://127.0.0.1:7077", appName, conf)
        // val sc = new SparkContext(conf)

        // com.basho.riak.spark.rdd.connector.RiakConnector

        // val kv_bucket_name = "bucket1"
        // val rdd = sc.riakBucket[String]("bucket1").queryAll()
        // rdd.collect().foreach(println)

        // val rdd = sc.riakBucket[String]("bucket1").queryAll()

        // rdd.map(_.toUpperCase).saveToRiak("new_bucket")
        println("spark riak!!!")

        // val rdd = sc.riakBucket[String]("bucket1").queryAll()
        // rdd.map(_.toUpperCase).saveToRiak("new_bucket")


        // val rdd = sc.riakBucket[String]("bucket1").queryAll()
        // rdd.collect().foreach(println)

        val data = Array(1, 2, 3, 4, 5)
        val testRDD = sc.parallelize(data)
        testRDD.saveToRiak("kv_bucket_a")



        // val rdd = sc.riakBucket[String]("bucket1").queryAll()
        // rdd.map(_.toUpperCase).saveToRiak("new_bucket")



        // println(data)

        // val rdd = sc.riakBucket[String](kv_bucket_name).queryBucketKeys("Alice", "Bob", "Charlie")
        // val rdd = sc.riakBucket[String](kv_bucket_name).query2iRange("myIndex", 1L, 5000L)
        // val rdd = sc.riakBucket[String](kv_bucket_name).partitionBy2iRanges("myIndex", 1->3, 4->6, 7->12)
        // val rdd = sc.riakBucket[String](kv_bucket_name).query2iKeys("dailyDataIndx", "mon_data", "wed_data", "fri_data")

        // val output_kv_bucket = "test-bucket"
        // rdd.saveToRiak(output_kv_bucket)



        sc.stop()
    }
}
