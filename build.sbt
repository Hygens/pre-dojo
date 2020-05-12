scalaVersion := "2.11.8"

name := "AmilGameLog-in-Scala"

organization := "com.amil.gamelog"

version := "1.0-SNAPSHOT"

// set the main class for the main 'sbt run' task
mainClass in (Compile, run) := Some("com.amil.gamelog.AmilGameLog")

description := "Amil Game Log"

publishMavenStyle := true

crossPaths := false

autoScalaLibrary := true

libraryDependencies ++= Seq(
   "org.apache.commons" % "commons-math3" % "3.1.1",
   "org.fluentd" % "fluent-logger" % "0.2.10",
   "org.scalactic" %% "scalactic" % "3.1.1",
   "org.scalatest" %% "scalatest" % "3.1.2" % Test  
)

