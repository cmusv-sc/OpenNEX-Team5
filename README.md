# OpenNEX-Team5

## Introduction
This project is part of OpenNEX. This demonstrates a workflow to build a scalable search and recommendation system.

## Setup
1. Install and configure Hadoop 
2. Install and configure Sqoop
3. Install and configure MySQL

## Helpful guides:
- http://www.tutorialspoint.com/sqoop/index.htm
- http://amodernstory.com/2014/09/23/installing-hadoop-on-mac-osx-yosemite/

## Running the Demo
* Run the app on port 8800 and start hdfs and yarn
```
# starts the Play app on port 8800
./activator "run 8800"
# Starts hadoop processes
$HADOOP_HOME/sbin/start-dfs.sh
$HADOOP_HOME/sbin/start-yarn.sh
```
* Import sample workflow data
```
cd generators/workflow
python mysql-import-workflow.py workflows.json
cd -
```
* Import data from MySQL to HDFS
```
sqoop import \
  --connect jdbc:mysql://localhost/opennex \
  --username root \
  --table workflow_entry \
  --m 1 \
  --target-dir /queryresult/workflow_entry
```
* Compile and Run the MetaTransform job to generate tag metadata for workflows
```
cd hadoop
sh hadoopJobToJar.sh MetaTransform.java
hadoop jar MetaTransform.jar MetaTransform /queryresult/workflow_entry /output/workflow_tags
```
* Export the result from HDFS back into MySQL
```
sqoop export \
  --connect jdbc:mysql://localhost/opennex \
  --username root \
  --table workflow_meta
  --export-dir /output/workflow_tags
```
* Start searching thru the /workflows/search/$tag API
```
curl http://localhost:8800/workflows/search/science
```

## More Info
Feel free to contact any of the team members:
- Cef Ramirez <cef.ramirez@sv.cmu.edu>
- Bin Lan <cef.ramirez@sv.cmu.edu>
- Jian Jiao <cef.ramirez@sv.cmu.edu>
- Xuan Zhang <xuan.zhang@sv.cmu.edu>
- Hanzhu Li <hanzhu.li@sv.cmu.edu>
