package io.craigmiller160.scalapetstore

import cats.effect.kernel.Sync
import cats.effect.{ExitCode, IO, IOApp, Resource}
import io.craigmiller160.scalapetstore.config._
import io.circe.config.{parser => configParser}
import io.craigmiller160.scalapetstore.config.AppConfig
import cats.effect._

object Runner extends IOApp {
  configParser.decodePath[AppConfig]("petstore") match {
    case Right(value) => println(value)
    case Left(ex) => ex.printStackTrace()
  }

  override def run(args: List[String]): IO[ExitCode] =
    createServer[IO].use(_ => IO.never).as(ExitCode.Success)

  private def createServer[F[_]: Sync]: Resource[F, Any] =
    for {
      appConfig <- Resource.eval(configParser.decodePath[AppConfig]("petstore"))
    } yield appConfig
}
