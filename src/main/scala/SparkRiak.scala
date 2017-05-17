// package Wordcount
// import org.apache.spark.SparkConf
// import org.apache.spark.SparkContext
// import org.apache.spark.SparkContext._


// /**
//  * @author hadoop
//  * 统计字符出现个数
//  *
//  */

// object Wordcount {
//   def main(args: Array[String]) {
//     if(args.length < 1) {
//       System.err.println("Usage: <file>")
//       System.exit(1)
//     }
//     val conf = new SparkConf()
//     val sc = new SparkContext(conf)
//     //SparkContext 是把代码提交到集群或者本地的通道，我们编写Spark代码，无论是要本地运行还是集群运行都必须有SparkContext的实例
//     val line = sc.textFile(args(0))
//     //把读取的内容保存给line变量，其实line是一个MappedRDD，Spark的所有操作都是基于RDD的
//     line.flatMap(_.split(" ")).map((_, 1)).reduceByKey(_+_).collect.foreach(println)
//     sc.stop
//   }
// }






object SparkRiak {
    def main(args: Array[String]): Unit = {
        println("spark riak!!!")
    }
}
