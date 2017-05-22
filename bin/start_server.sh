#!/bin/bash


#riak start 

/usr/local/spark/sbin/start-master.sh -h 127.0.0.1

/usr/local/spark/sbin/start-slave.sh spark://127.0.0.1:7077


