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


cp /web/tar/snappy-1.1.4/.libs/libsnappy.dylib /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/


//sudo cp /web/spark-riak/doc/libhadoop.so /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/libhadoop.dylib

*****************************************************
*****************************************************
17/05/21 09:51:48 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
这个警告提示，就是要自己要本地编绎hadoop后将 libhadoop.dylib文件复制到java的相应路径下面：如下
你们城里人真会玩，我己经被打败了，

sudo cp /web/tar/hadoop-2.7.3-src/hadoop-dist/target/hadoop-2.7.3/lib/native/libhadoop.dylib /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/libhadoop.dylib


=============================================================================================

编绎hadoop:
http://www.micmiu.com/bigdata/hadoop/hadoop-build-native-library-on-mac-os-x/


svn co https://svn.apache.org/repos/asf/hadoop/common/tags/release-2.2.0/

cd release-2.2.0/



 #切换到hadoop 源码的根目录
wget https://issues.apache.org/jira/secure/attachment/12617363/HADOOP-9648.v2.patch
patch -p1 < HADOOP-9648.v2.patch




mvn package -Pdist,native -DskipTests -Dtar
mvn package -Pdist,native -DskipTests -Dtar -Dmaven.javadoc.skip=true


编译通过后可在 <HADOOP源码根目录>/hadoop-dist/target/hadoop-2.2.0/lib/ 目录下看到如下内容：



$ls -s libhadoop.1.0.0.dylib libhadoop.so 
$ls -s libhdfs.0.0.0.dylib libhdfs.so


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

http://www.cnblogs.com/huaxiaoyao/p/5085511.html
spark-env.sh 配置示例


#spark-env.sh 

JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/
SCALA_HOME=/usr/local/scala
SPARK_HOME=/usr/local/spark-2.1.1-bin-hadoop2.7
SPARK_PID_DIR=$SPARK_HOME/tmp
HADOOP_HOME=/usr/local/hadoop-2.7.3

#HADOOP_CONF_DIR=/home/hadoop/app/hadoop/etc/hadoop

SPARK_CLASSPATH=$SPARK_HOME/conf/:$SPARK_HOME/lib/*:$HADOOP_HOME/share/hadoop/common/lib/hadoop-lzo-0.4.19.jar:/home/hadoop/app/hbase/conf:$HADOOP_HOME/lib/native:$SPARK_CLASSPATH
SPARK_JAVA_OPTS="$SPARK_JAVA_OPTS -Dspark.akka.askTimeout=300 -Dspark.ui.retainedStages=1000 -Dspark.eventLog.enabled=true -Dspark.eventLog.dir=hdfs://sparkcluster/user/spark_history_logs -Dspark.shuffle.spill=false -Dspark.shuffle.manager=hash -Dspark.yarn.max.executor.failures=99999 -Dspark.worker.timeout=300"
SPARK_LOCAL_DIRS=/data1/hadoop/spark_local_dir,/data2/hadoop/spark_local_dir,/data3/hadoop/spark_local_dir,/data4/hadoop/spark_local_dir,/data5/hadoop/spark_local_dir,/data6/hadoop/spark_local_dir,/data7/hadoop/spark_local_dir,/data8/hadoop/spark_local_dir,/data9/hadoop/spark_local_dir,/data10/hadoop/spark_local_dir

SPARK_MASTER_PORT=4050
SPARK_WORKER_CORES=30
SPARK_WORKER_MEMORY=60g
SPARK_WORKER_INSTANCES=6
SPARK_DRIVER_MEMORY=12g
SPARK_DAEMON_JAVA_OPTS="-Dspark.deploy.recoveryMode=ZOOKEEPER -Dspark.deploy.zookeeper.url=spark1:2181,spark2:2181,spark3:2181 $SPARK_DAEMON_JAVA_OPTS"


==================================================================


http://blog.csdn.net/stark_summer/article/details/48375999



export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/home/cluster/apps/hadoop/lib/native
export SPARK_LIBRARY_PATH=$SPARK_LIBRARY_PATH:/home/cluster/apps/hadoop/lib/native
export SPARK_CLASSPATH=$SPARK_CLASSPATH:/home/cluster/apps/hadoop/share/hadoop/yarn/*:/home/cluster/apps/hadoop/share/hadoop/yarn/lib/*:/home/cluster/apps/hadoop/share/hadoop/common/*:/home/cluster/apps/hadoop/share/hadoop/common/lib/*:/home/cluster/apps/hadoop/share/hadoop/hdfs/*:/home/cluster/apps/hadoop/share/hadoop/hdfs/lib/*:/home/cluster/apps/hadoop/share/hadoop/mapreduce/*:/home/cluster/apps/hadoop/share/hadoop/mapreduce/lib/*:/home/cluster/apps/hadoop/share/hadoop/tools/lib/*:/home/cluster/apps/spark/spark-1.4.1/lib/*




/usr/local/spark-2.1.1-bin-hadoop2.7/conf/spark-env.sh

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/
export SCALA_HOME=/usr/local/scala
export SPARK_HOME=/usr/local/spark-2.1.1-bin-hadoop2.7

export HADOOP_HOME=/usr/local/hadoop-2.7.3
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$HADOOP_HOME/lib/native/*
export SPARK_LIBRARY_PATH=$SPARK_LIBRARY_PATH:$HADOOP_HOME/lib/native/*
export SPARK_CLASSPATH=$SPARK_CLASSPATH:$HADOOP_HOME/share/hadoop/yarn/*:$HADOOP_HOME/share/hadoop/yarn/lib/*:$HADOOP_HOME/share/hadoop/common/*:$HADOOP_HOME/share/hadoop/common/lib/*:$HADOOP_HOME/share/hadoop/hdfs/*:$HADOOP_HOME/share/hadoop/hdfs/lib/*:$HADOOP_HOME/share/hadoop/mapreduce/*:$HADOOP_HOME/share/hadoop/mapreduce/lib/*:$HADOOP_HOME/share/hadoop/tools/lib/*




:/home/cluster/apps/spark/spark-1.4.1/lib/*




