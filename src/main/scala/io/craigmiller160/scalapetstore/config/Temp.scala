package io.craigmiller160.scalapetstore.config

import io.circe._, io.circe.parser._
import io.circe.generic.semiauto._

object Temp extends App {
  val rawJson: String = """
{
  "foo": "bar",
  "baz": 123,
  "list of stuff": [ 4, 5, 6 ]
}
"""

  val json2: String = """{"foo":"bar"}"""

  val result = parser.parse(rawJson)
//  result match {
//    case Right(value) =>
//      value.as
//  }

  case class Config(foo: String)
  implicit val configDecoder: Decoder[Config] = deriveDecoder

  parser.parse(json2) match {
    case Right(value) =>
      value.as[Config] match {
        case Right(config) =>
          println(config.foo)
        case Left(ex) =>
          println("Decoding failure")
          ex.printStackTrace()
      }
    case Left(ex) =>
      println("parsing failure")
      ex.printStackTrace()
  }
}
