package io.craigmiller160.scalapetstore

import io.craigmiller160.scalapetstore.config._
import io.circe.parser
import io.circe.config.{parser => configParser}
import io.craigmiller160.scalapetstore.config.AppConfig

import java.io.{BufferedReader, InputStreamReader}
import java.util.stream.Collectors

object Runner extends App {
  println("V1 Approach")
  val stream = getClass.getClassLoader.getResourceAsStream("application.json")
  val text = new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.joining("\n"))
  parser.parse(text)
    .flatMap(_.as[AppConfig])
    .foreach(config => println(config))

  println("V2 Approach")
  configParser.decodePath[AppConfig]("petstore") match {
    case Right(value) => println(value)
    case Left(ex) => ex.printStackTrace()
  }
}
