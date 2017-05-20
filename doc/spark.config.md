spark.config.md

spark-2.1.1-bin-hadoop2.7
hadoop-2.7.3
riak-ts-1.5.2-OSX-x86_64








http://blog.csdn.net/stark_summer/article/details/48375999



export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/home/cluster/apps/hadoop/lib/native
export SPARK_LIBRARY_PATH=$SPARK_LIBRARY_PATH:/home/cluster/apps/hadoop/lib/native
export SPARK_CLASSPATH=$SPARK_CLASSPATH:/home/cluster/apps/hadoop/share/hadoop/yarn/*:/home/cluster/apps/hadoop/share/hadoop/yarn/lib/*:/home/cluster/apps/hadoop/share/hadoop/common/*:/home/cluster/apps/hadoop/share/hadoop/common/lib/*:/home/cluster/apps/hadoop/share/hadoop/hdfs/*:/home/cluster/apps/hadoop/share/hadoop/hdfs/lib/*:/home/cluster/apps/hadoop/share/hadoop/mapreduce/*:/home/cluster/apps/hadoop/share/hadoop/mapreduce/lib/*:/home/cluster/apps/hadoop/share/hadoop/tools/lib/*:/home/cluster/apps/spark/spark-1.4.1/lib/*






export HADOOP_HOME=/usr/local/hadoop-2.7.3
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$HADOOP_HOME/lib/native/*
export SPARK_LIBRARY_PATH=$SPARK_LIBRARY_PATH:$HADOOP_HOME/lib/native/*
export SPARK_CLASSPATH=$SPARK_CLASSPATH:$HADOOP_HOME/share/hadoop/yarn/*:$HADOOP_HOME/share/hadoop/yarn/lib/*:$HADOOP_HOME/share/hadoop/common/*:$HADOOP_HOME/share/hadoop/common/lib/*:$HADOOP_HOME/share/hadoop/hdfs/*:$HADOOP_HOME/share/hadoop/hdfs/lib/*:$HADOOP_HOME/share/hadoop/mapreduce/*:$HADOOP_HOME/share/hadoop/mapreduce/lib/*:$HADOOP_HOME/share/hadoop/tools/lib/*


:/home/cluster/apps/spark/spark-1.4.1/lib/*




