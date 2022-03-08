package io.craigmiller160.scalapetstore

import io.craigmiller160.scalapetstore.config._
import io.circe._
import io.craigmiller160.scalapetstore.config.AppConfig

import java.io.{BufferedReader, InputStreamReader}
import java.util.stream.Collectors

object Runner extends App {
  val stream = getClass.getClassLoader.getResourceAsStream("application.json")
  val text = new BufferedReader(new InputStreamReader(stream)).lines().collect(Collectors.joining("\n"))
  parser.parse(text)
    .flatMap(_.as[AppConfig])
    .foreach(config => println(config))
}
