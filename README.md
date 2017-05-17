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

	$ ./sbin/start-master.sh

启动 riak:
	
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


