mkdir idandtags_classes
javac -classpath {your hadoop-core.jar file path} -d idandtags_classes IdAndTag.java
jar -cvf idandtags.jar -C idandtags_classes/ .
