ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

val catsVersion = "2.7.0"
val doobieVersion = "1.0.0-RC2"
val circeVersion = "0.14.1"
val pgVersion = "42.3.3"
val circeConfigVersion = "0.8.0"
val logbackVersion = "1.2.10"
val slf4jVersion = "1.7.36"

libraryDependencies += "org.typelevel" %% "cats-core" % catsVersion
libraryDependencies += "org.tpolecat" %% "doobie-core" % doobieVersion
libraryDependencies += "org.tpolecat" %% "doobie-hikari" % doobieVersion
libraryDependencies += "org.tpolecat" %% "doobie-postgres" % doobieVersion
libraryDependencies += "io.circe" %% "circe-parser" % circeVersion
libraryDependencies += "io.circe" %% "circe-generic" % circeVersion
libraryDependencies += "io.circe" %% "circe-core" % circeVersion
libraryDependencies += "io.circe" %% "circe-config" % circeConfigVersion
libraryDependencies += "org.postgresql" % "postgresql" % pgVersion
libraryDependencies += "ch.qos.logback" % "logback-classic" % logbackVersion

dependencyOverrides += "org.slf4j" % "slf4j-api" % slf4jVersion

lazy val root = (project in file("."))
  .settings(
    name := "scala-pet-store-rewrite"
  )
