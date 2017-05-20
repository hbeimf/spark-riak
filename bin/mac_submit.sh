#!/bin/bash

# doc
# http://www.cnblogs.com/gaopeng527/p/4366505.html
# http://www.cnblogs.com/missmzt/p/6002858.html
# http://www.cnblogs.com/xiaomaohai/p/6158065.html
# https://my.oschina.net/cjun/blog/509247
# http://www.cnblogs.com/itboys/p/6007674.html



# cd $SPARK_HOME/bin
# spark-submit \
# --master spark://127.0.0.1:7077 \
# --class Wordcount.Wordcount \
# --name wordcount \
# --executor-memory 400M \
# --driver-memory 512M \
# /usr/local/myjar/wordcount.jar \
# hdfs://127.0.0.1:9000/web/helloWorld/wordcount.txt

# ===================================================
# http://www.tuicool.com/articles/ZJFJ3i

# Run on a Spark standalone cluster
# ./bin/spark-submit \
#   --class org.apache.spark.examples.SparkPi \
#   --master spark://207.184.161.138:7077 \
#   --executor-memory 20G \
#   --total-executor-cores 100 \
#   /path/to/examples.jar \
#   1000
# ======================================================
# http://www.mamicode.com/info-detail-554020.html

# mac 
/usr/local/spark-2.1.1-bin-hadoop2.7/bin/spark-submit \
  --class SparkRiak.SparkRiak \
  --master spark://127.0.0.1:7077 \
  --executor-memory 1000M \
  --total-executor-cores 100 \
  /web/spark-riak/target/scala-2.10/spark-riak-assembly-0.0.1.jar


































