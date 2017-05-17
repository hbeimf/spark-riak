#!/bin/bash

# doc
# http://www.cnblogs.com/gaopeng527/p/4366505.html
# http://www.cnblogs.com/missmzt/p/6002858.html

cd $SPARK_HOME/bin
spark-submit \
--master spark://127.0.0.1:7077 \
--class Wordcount.Wordcount \
--name wordcount \
--executor-memory 400M \
--driver-memory 512M \
/usr/local/myjar/wordcount.jar \
hdfs://127.0.0.1:9000/web/helloWorld/wordcount.txt
