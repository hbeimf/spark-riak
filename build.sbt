name := "spark-riak"      // 项目名称

// organization := "xxx.xxx.xxx"  // 组织名称

version := "0.0.1"  // 版本号



//scalaVersion := "2.12.2"   // 使用的Scala版本号
scalaVersion := "2.10.6"   // 使用的Scala版本号



// https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.10
libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.5.0" % "provided"
// https://mvnrepository.com/artifact/org.apache.spark/spark-core_2.10
//libraryDependencies += "org.apache.spark" % "spark-core_2.10" % "1.6.0"


// https://mvnrepository.com/artifact/org.apache.spark/spark-sql_2.10
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.5.0"




// https://mvnrepository.com/artifact/com.basho.riak/spark-riak-connector_2.10
//libraryDependencies += "com.basho.riak" % "spark-riak-connector_2.10" % "1.6.0"
// https://mvnrepository.com/artifact/com.basho.riak/spark-riak-connector_2.10
libraryDependencies += "com.basho.riak" % "spark-riak-connector_2.10" % "1.6.3"







