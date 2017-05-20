#!/bin/bash


riak start 

/usr/local/spark-2.1.1-bin-hadoop2.7/sbin/start-master.sh -h 127.0.0.1

/usr/local/spark-2.1.1-bin-hadoop2.7/sbin/start-slave.sh spark://127.0.0.1:7077


