name := "halselhof"

organization := "org.restfulscala"

version := "0.4.0"

scalaVersion := "2.12.10"
crossScalaVersions := Seq("2.11.8", "2.12.10", "2.13.1")

scalacOptions  ++= Seq("-unchecked", "-deprecation", "-feature")

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.7.4" % "provided"

libraryDependencies += "com.typesafe.play" %% "play" % "2.7.4" % "provided"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % "test"

bintrayOrganization := Some("restfulscala")

bintrayPackageLabels := Seq("scala", "rest", "play")

licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
