add deps

http://mvnrepository.com/

search groupId/artifactId/version


打包应用:

	$ sbt package
	$ ll ./target/scala-2.12/

	print like this
	/helloWorld$ ll ./target/scala-2.12/
	drwxrwxr-x 3 xxx xxx 4096  5月 16 13:58 ./
	drwxrwxr-x 5 xxx xxx 4096  5月 16 13:52 ../
	drwxrwxr-x 2 xxx xxx  5月 16 13:50 classes/
	-rw-rw-r-- 1 xxx xxx 1819  5月 16 13:58 helloworld_2.12-0.0.1.jar


启动 spark:

	spark-2.1.1-bin-hadoop2.7

	$ ./sbin/start-master.sh -h 127.0.0.1
	查看master状态
	http://localhost:8080/

启动 riak:

	riak-ts_1.5.2-1_amd64.deb
	$ sudo riak start


submit:

	./bin/spark-submit \

	--class<main-class>

	--master <master-url> \

	--deploy-mode <deploy-mode> \

	--conf<key>=<value> \

	... #other options

	<application-jar> \

	[application-arguments]




https://segmentfault.com/q/1010000003943723

sbt assembly
