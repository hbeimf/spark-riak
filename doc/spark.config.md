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



===========================================================================

http://www.cnblogs.com/huaxiaoyao/p/5085511.html
spark-env.sh 配置示例

您们城里人就是会玩,我已经被打败了~
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




