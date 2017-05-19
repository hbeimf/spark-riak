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
libraryDependencies += "org.apache.spark" % "spark-sql_2.10" % "1.5.0"




// https://mvnrepository.com/artifact/com.basho.riak/spark-riak-connector_2.10
//libraryDependencies += "com.basho.riak" % "spark-riak-connector_2.10" % "1.6.0"
// https://mvnrepository.com/artifact/com.basho.riak/spark-riak-connector_2.10
libraryDependencies += "com.basho.riak" % "spark-riak-connector_2.10" % "1.6.3"


// =================================================================================
// 冲突解决
// sbt-assembly deduplicate
// sbt-assembly spark deduplicate

//http://www.doc88.com/p-2012378335978.html
//http://www.itkeyword.com/doc/9483198137802918599/sbt-assembly-error-deduplicate-different-file-contents-found-in-the-following

// http://blog.csdn.net/xiewenbo/article/details/53573440　

// mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
//  {
//    case PathList("org", "slf4j", xs @ _*)         => MergeStrategy.first
//    case PathList(ps @ _*) if ps.last endsWith "axiom.xml" => MergeStrategy.filterDistinctLines
//    case PathList(ps @ _*) if ps.last endsWith "Log$Logger.class" => MergeStrategy.first
//    case PathList(ps @ _*) if ps.last endsWith "ILoggerFactory.class" => MergeStrategy.first
//    case x => old(x)
//  }
//}
//






// http://www.tuicool.com/articles/URzmqaB

// build.sbt

// // import sbt.Keys._

// // name := "spark-dse-test"

// // version := "1.0"

// // scalaVersion := "2.10.5"

// // scalacOptions := Seq("-deprecation", "-unchecked", "-feature")

// // libraryDependencies ++= Seq(
// //   "com.datastax.spark" %% "spark-cassandra-connector" % "1.5.0-M2",
// //   "org.apache.spark" %% "spark-core" % "1.5.1" % "provided",
// //   "org.apache.spark" %% "spark-sql" % "1.5.1" % "provided"
// // )

// // // There is a conflict between Guava versions on Cassandra Drive and Hadoop
// // // Shading Guava Package
// // assemblyShadeRules in assembly := Seq(
// //   ShadeRule.rename("com.google.**" -> "shadeio.@1").inAll
// // )

// // assemblyJarName in assembly := s"${name.value}-${version.value}.jar"

// // assemblyMergeStrategy in assembly := {
// //   case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
// //   case _ => MergeStrategy.first
// // }


// mergeStrategy in assembly <<= (mergeStrategy in assembly) { mergeStrategy => {
// case entry => {
//   val strategy = mergeStrategy(entry)
//   if (strategy == MergeStrategy.deduplicate) MergeStrategy.first
//   else strategy
// }
//}}
//

//https://github.com/sbt/sbt-assembly#merge-strategy
// http://blog.csdn.net/beautygao/article/details/32306637
// https://github.com/sbt/sbt-assembly/issues/92
// https://github.com/sbt/sbt-assembly/issues

//assemblyShadeRules in assembly := Seq(
//  ShadeRule.rename("com.typesafe.config.**" -> "my_conf.@1")
//    .inLibrary("com.typesafe" % "config" % "1.3.0")
//    .inProject
//)//
