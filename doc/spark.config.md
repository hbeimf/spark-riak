spark.config.md

spark-2.1.1-bin-hadoop2.7
hadoop-2.7.3
riak-ts-1.5.2-OSX-x86_64

===========================================================================

RIAK_HOME=/usr/local/riak-ts-1.5.2
PATH=$RIAK_HOME/bin:$PATH
export RIAK_HOME PATH
 
SCALA_HOME=/usr/local/scala
PATH=$SCALA_HOME/bin:$PATH
export SCALA_HOME PATH
 
SPARK_HOME=/usr/local/spark-2.1.1-bin-hadoop2.7
PATH=$SPARK_HOME/bin:$PATH
export SPARK_HOME PATH


/usr/local/hadoop-2.7.3
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/



scala版本2.10.X，spark1.5开始你可以用scala2.11.X


cp /usr/local/hadoop-2.7.3/etc/hadoop/core-site.xml /usr/local/spark-2.1.1-bin-hadoop2.7/conf/
cp /usr/local/hadoop-2.7.3/etc/hadoop/hdfs-site.xml /usr/local/spark-2.1.1-bin-hadoop2.7/conf/




============================================================================
WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
https://www.zhihu.com/question/23974067/answer/26267153

http://download.openpkg.org/components/cache/snappy/

主要是jre目录下缺少了libhadoop.so和libsnappy.so两个文件。具体是，spark-shell依赖的是scala，scala依赖的是JAVA_HOME下的jdk，libhadoop.so和libsnappy.so两个文件应该放到$JAVA_HOME/jre/lib/amd64下面。这两个so：libhadoop.so和libsnappy.so。前一个so可以在HADOOP_HOME下找到，如hadoop\lib\native。第二个libsnappy.so需要下载一个snappy-1.1.0.tar.gz，然后./configure，make编译出来，编译成功之后在.libs文件夹下。当这两个文件准备好后再次启动spark shell不会出现这个问题。

作者：Edward Lee
链接：https://www.zhihu.com/question/23974067/answer/26267153
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

// /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/amd64/
============================================================================================
Snappy压缩库安装
http://www.xuebuyuan.com/1268888.html


sudo cp /web/tar/snappy-1.1.4/.libs/libsnappy.dylib /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/




*****************************************************
*****************************************************
17/05/21 09:51:48 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
这个警告提示，就是要自己要本地编绎hadoop后将 libhadoop.dylib文件复制到java的相应路径下面：如下
你们城里人真会玩，我己经被打败了，

sudo cp /web/tar/hadoop-2.7.3-src/hadoop-dist/target/hadoop-2.7.3/lib/native/libhadoop.dylib /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/libhadoop.dylib


------------------------------------------------------
cp -R /web/tar/hadoop-2.7.3-src/hadoop-dist/target/hadoop-2.7.3/lib/native /usr/local/hadoop-2.7.3/lib/

cd /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/
sudo rm -rf libsnappy.dylib
sudo rm -rf libhadoop.dylib





cp /web/tar/snappy-1.1.4/.libs/libsnappy.dylib /usr/local/hadoop-2.7.3/lib/native/

=============================================================================================

编绎hadoop:
http://www.micmiu.com/bigdata/hadoop/hadoop-build-native-library-on-mac-os-x/


mvn package -Pdist,native -DskipTests -Dtar
mvn package -Pdist,native -DskipTests -Dtar -Dmaven.javadoc.skip=true



==========================================================================
protobuf install 


   ./configure --prefix=/usr/local/protobuf/  

    make && make install


/usr/local/protobuf/bin


PROTOBUF_HOME=/usr/local/protobuf
PATH=$PROTOBUF_HOME/bin:$PATH
export PROTOBUF_HOME PATH

=========================================================================
maven

http://blog.csdn.net/u010717403/article/details/52188496
 <mirrors>
    <mirror>
      <id>alimaven</id>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>        
    </mirror>
  </mirrors>

===========================================================================


********************************************
刚踏过一个坑，又来了一个，

Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/spark/Logging


http://blog.csdn.net/u010906369/article/details/52884321

http://blog.csdn.net/u010906369/article/details/52884321







spark-1.5.0-bin-hadoop2.6
riak-ts-1.5.2
scala-2.10.6

apache-maven-3.5.0













