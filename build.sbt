ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.2.0"

lazy val root = (project in file("."))
  .settings(
    name := "scala-99-evan"
  )

