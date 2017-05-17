name := "spark-riak"      // 项目名称

// organization := "xxx.xxx.xxx"  // 组织名称

version := "0.0.1"  // 版本号

scalaVersion := "2.12.2"   // 使用的Scala版本号

// 添加项目依赖
// libraryDependencies += "ch.qos.logback" % "logback-core" % "1.0.0"

// libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.0.0"

// 或者

libraryDependencies ++= Seq(
                        "org.apache.spark" % "spark-core_2.10" % "2.1.1"
                        //"org.apache.spark" % "spark-streaming_2.10" % "2.1.1"

                        // "org.apache.spark" % "park-sql_2.10" % "2.1.1"
                        )



// 添加测试代码编译或者运行期间使用的依赖
// libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "1.8" % "test")
