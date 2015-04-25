export JAVA_HOME=$(/usr/libexec/java_home)
/Users/zhangxuan/Downloads/hadoop-1.2.1/bin/hadoop jar /Users/zhangxuan/usagecount.jar UsageCount /Users/zhangxuan/ucinput /Users/zhangxuan/$(date +%Y%m%d_%H%M%S) 
