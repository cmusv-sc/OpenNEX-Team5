mkdir usagecount_classes
javac -classpath {your hadoop-core.jar file path} -d usagecount_classes UsageCount.java
jar -cvf usagecount.jar -C usagecount_classes/ .
