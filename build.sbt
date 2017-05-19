net.virtualvoid.sbt.graph.Plugin.graphSettings
import AssemblyKeys._

assemblySettings

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
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.5.0" % "provided"




// https://mvnrepository.com/artifact/com.basho.riak/spark-riak-connector_2.10
//libraryDependencies += "com.basho.riak" % "spark-riak-connector_2.10" % "1.6.0"
// https://mvnrepository.com/artifact/com.basho.riak/spark-riak-connector_2.10
libraryDependencies += "com.basho.riak" % "spark-riak-connector_2.10" % "1.6.3"


// =================================================================================
// 冲突解决
// sbt-assembly deduplicate
// sbt-assembly spark deduplicate

mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  {
    //case PathList("org", "slf4j", xs @ _*)         => MergeStrategy.first
    //case PathList(ps @ _*) if ps.last endsWith "axiom.xml" => MergeStrategy.filterDistinctLines
    //case PathList(ps @ _*) if ps.last endsWith "Log$Logger.class" => MergeStrategy.first
    //case PathList(ps @ _*) if ps.last endsWith "ILoggerFactory.class" => MergeStrategy.first

    case PathList("org", "apache", xs @ _*)         => MergeStrategy.last
    case PathList(ps @ _*) if ps.last endsWith "pom.properties" => MergeStrategy.last
    case PathList(ps @ _*) if ps.last endsWith "pom.xml" => MergeStrategy.last
    case PathList(ps @ _*) if ps.last endsWith "Log.class" => MergeStrategy.last
    case PathList(ps @ _*) if ps.last endsWith "Log$Logger.class" => MergeStrategy.last
    case PathList(ps @ _*) if ps.last endsWith "Absent.class" => MergeStrategy.last
    case PathList(ps @ _*) if ps.last endsWith "Function.class" => MergeStrategy.last

    case x => old(x)
  }
}






