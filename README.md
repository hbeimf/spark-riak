安装版本:

/usr/local/

	spark -> ./spark-1.5.0-bin-hadoop2.6/
	scala -> ./scala-2.10.6/
	riak-ts_1.5.2-1_amd64.deb

	> sbtVersion
	[info] 0.13.11
	>

=========================================================

/etc/profile


	SCALA_HOME=/usr/local/scala
	PATH=$SCALA_HOME/bin:$PATH
	export SCALA_HOME PATH

	SBT_HOME=/usr/local/sbt
	PATH=$SBT_HOME/bin:$PATH
	export SBT_HOME PATH

	SPARK_HOME=/usr/local/spark
	PATH=$SPARK_HOME/bin:$PATH
	export SPARK_HOME PATH

===========================================================

启动/停上　riakts

	sudo riak start
	sudo riak stop

===========================================================

启动本地测试spark:

	/usr/local/spark/sbin/start-master.sh -h 127.0.0.1
	/usr/local/spark/sbin/start-slave.sh spark://127.0.0.1:7077

停止测试spark:

	/usr/local/spark/sbin/start-slave.sh
	/usr/local/spark/sbin/stop-master.sh

============================================================

查看master状态

	http://localhost:8080/

============================================================

sbt 依赖添加查找：

	add deps

	http://mvnrepository.com/

	search groupId/artifactId/version

==============================================================


编绎&打包应用:

	$ sbt compile
	$ sbt assembly

===============================================================

提交任务到spark运行测试：

	$ bash ./bin/ubuntu_submit.sh

================================================================
spark-riak-connector 文档：

	https://github.com/basho/spark-riak-connector#compatibility

	https://github.com/basho/spark-riak-connector/blob/master/docs/using-connector.md#reading-data-from-kv-bucket


