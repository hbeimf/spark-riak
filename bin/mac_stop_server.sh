#!/bin/bash


riak stop

/usr/local/spark-2.1.1-bin-hadoop2.7/sbin/stop-slave.sh
/usr/local/spark-2.1.1-bin-hadoop2.7/sbin/stop-master.sh



