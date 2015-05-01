name := """play-java-intro"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  "mysql" % "mysql-connector-java" % "5.1.21",
  "com.google.code.gson" % "gson" % "2.3.1" )
