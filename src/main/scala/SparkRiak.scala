package SparkRiak

import org.apache.spark.{SparkContext, SparkConf}
import com.basho.riak.spark._

import com.basho.riak.spark.writer.{WriteDataMapper, WriteDataMapperFactory}



// https://github.com/basho/spark-riak-connector/blob/master/docs/using-connector.md#configuration-of-spark-context

object SparkRiak {
    def main(args: Array[String]): Unit = {
        val conf = new SparkConf()
        .setAppName("SparkRiak")
        .set("spark.riak.connection.host", "127.0.0.1:8087")
        .set("spark.riak.connections.min", "20")
        .set("spark.riak.connections.max", "50")

        val taskName = "SparkRiak"
        val sc = new SparkContext("spark://127.0.0.1:7077", taskName, conf)

        // val kv_bucket_name = "test-data"
        // val data = sc.riakBucket[String](kv_bucket_name).queryAll()
        // val rdd = sc.riakBucket[String](kv_bucket_name).queryBucketKeys("Alice", "Bob", "Charlie")
        // val rdd = sc.riakBucket[String](kv_bucket_name).query2iRange("myIndex", 1L, 5000L)
        // val rdd = sc.riakBucket[String](kv_bucket_name).partitionBy2iRanges("myIndex", 1->3, 4->6, 7->12)
        // val rdd = sc.riakBucket[String](kv_bucket_name).query2iKeys("dailyDataIndx", "mon_data", "wed_data", "fri_data")

        // val output_kv_bucket = "test-bucket"
        // rdd.saveToRiak(output_kv_bucket)

        println("spark riak!!!")

        sc.stop()
    }
}
