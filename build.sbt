//net.virtualvoid.sbt.graph.Plugin.graphSettings
// import AssemblyKeys._

// assemblySettings

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


// =================================================================================
// 冲突解决
// sbt-assembly deduplicate
// sbt-assembly spark deduplicate


//
//[error] (*:assembly) deduplicate: different file contents found in the following:
//[error] /home/maomao/.ivy2/cache/com.google.protobuf/protobuf-java/bundles/protobuf-java-2.5.0.jar:META-INF/maven/com.google.protobuf/protobuf-java/pom.properties
//[error] /home/maomao/.ivy2/cache/org.apache.mesos/mesos/jars/mesos-0.21.1-shaded-protobuf.jar:META-INF/maven/com.google.protobuf/protobuf-java/pom.properties
//[error] /home/maomao/.ivy2/cache/com.basho.riak/riak-client/jars/riak-client-2.0.7.jar:META-INF/maven/com.google.protobuf/protobuf-java/pom.properties

assemblyShadeRules in assembly := Seq(
  ShadeRule.rename("com.google.**" -> "shadeio11.@1").inAll,
  ShadeRule.rename("com.esotericsoftware.**" -> "shadeio22.@1").inAll,
  ShadeRule.rename("org.apache.**" -> "shadeio33.@1").inAll

)

//assemblyShadeRules in assembly := Seq(
//  ShadeRule.rename("com.google.guava.**" -> "shadeio44.@1").inAll
//)



assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)


//mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
  //{
    //case PathList("org", "slf4j", xs @ _*)         => MergeStrategy.first
    //case PathList(ps @ _*) if ps.last endsWith "axiom.xml" => MergeStrategy.filterDistinctLines
    //case PathList(ps @ _*) if ps.last endsWith "Log$Logger.class" => MergeStrategy.first
    //case PathList(ps @ _*) if ps.last endsWith "ILoggerFactory.class" => MergeStrategy.first

    //case PathList("org", "apache", xs @ _*)         => MergeStrategy.last

    //case PathList(ps @ _*) if ps.last endsWith "pom.properties" => MergeStrategy.last
    //case PathList(ps @ _*) if ps.last endsWith "pom.xml" => MergeStrategy.last
    //case PathList(ps @ _*) if ps.last endsWith "Log.class" => MergeStrategy.last
    //case PathList(ps @ _*) if ps.last endsWith "Log$Logger.class" => MergeStrategy.last
    //case PathList(ps @ _*) if ps.last endsWith "Absent.class" => MergeStrategy.last
    //case PathList(ps @ _*) if ps.last endsWith "Function.class" => MergeStrategy.last

    //case x => old(x)
  //}
//}






