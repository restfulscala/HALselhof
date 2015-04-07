name := "play-hal"

organization := "net.atinu"

version := "0.1.0"

scalaVersion := "2.11.5"

crossScalaVersions := Seq("2.11.6", "2.10.5")

scalacOptions  ++= Seq("-unchecked", "-deprecation", "-feature")

resolvers += "typesafe repo" at "http://repo.typesafe.com/typesafe/releases/"

scalariformSettings

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.3.7" % "provided"

libraryDependencies += "com.typesafe.play" %% "play" % "2.3.7" % "provided"

libraryDependencies += "org.scalatestplus" %% "play" % "1.1.0" % "test"

bintray.Plugin.bintraySettings

bintray.Keys.bintrayOrganization in bintray.Keys.bintray := Some("restfulscala")

bintray.Keys.packageLabels in bintray.Keys.bintray := Seq("scala", "rest", "play")

    