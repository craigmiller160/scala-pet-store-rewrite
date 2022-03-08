package io.craigmiller160.scalapetstore

import cats.effect.{Async, ExitCode, IO, IOApp, Resource}
import io.craigmiller160.scalapetstore.config._
import io.circe.config.{parser => configParser}
import io.craigmiller160.scalapetstore.config.AppConfig

object Runner extends IOApp {
  override def run(args: List[String]): IO[ExitCode] =
    createServer[IO].use(config => IO.println(config)).as(ExitCode.Success)

  private def createServer[F[_]: Async]: Resource[F, AppConfig] =
    for {
      appConfig <- Resource.eval(configParser.decodePathF[F, AppConfig]("petstore"))
      execCtxConfig <- ExecContextConfig.executionContexts[F](appConfig)
    } yield appConfig
}
