ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

val catsVersion = "2.7.0"
val doobieVersion = "1.0.0-RC2"
val circeVersion = "0.14.1"

libraryDependencies += "org.typelevel" %% "cats-core" % catsVersion
libraryDependencies += "org.tpolecat" %% "doobie-core" % doobieVersion
libraryDependencies += "org.tpolecat" %% "doobie-hikari" % doobieVersion
libraryDependencies += "org.tpolecat" %% "doobie-postgres" % doobieVersion
libraryDependencies += "io.circe" %% "circe-parser" % circeVersion
libraryDependencies += "io.circe" %% "circe-generic" % circeVersion
libraryDependencies += "io.circe" %% "circe-core" % circeVersion

lazy val root = (project in file("."))
  .settings(
    name := "scala-pet-store-rewrite"
  )
