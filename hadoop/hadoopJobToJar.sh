#!/bin/sh

# compile a .java job to a jar with the same name
classFile=$1

if [ ! -e "$classFile" ]
then
	echo "Need to provide valid class file to compile!"
	echo "Usage: ./hadoopJobToJar.sh [.java file]" 
	exit 1
fi

JAVA_HOME=$(/usr/libexec/java_home)
HADOOP_CLASSPATH=$(hadoop classpath)

filename=$(basename "$classFile")
extension="${filename##*.}"
filename="${filename%.*}"

tmpdir="${filename}_classes"
jarname="${filename}.jar"

mkdir "${tmpdir}"
javac -classpath "${HADOOP_CLASSPATH}" -d "${tmpdir}" "${classFile}"
jar -cvf "${jarname}" -C "${tmpdir}/" .