package io.craigmiller160.scalapetstore.config

import cats.effect.{Async, Resource}
import doobie.hikari.HikariTransactor

import scala.concurrent.ExecutionContext

case class DatabaseConfig(
                           url: String,
                           driver: String,
                           user: String,
                           password: String,
                           connections: DatabaseConnectionsConfig,
                         )
object DatabaseConfig {
  def dbTransactor[F[_]: Async](config: DatabaseConfig,
                                execCtx: ExecutionContext): Resource[F, HikariTransactor[F]] =
    HikariTransactor.newHikariTransactor(config.driver, config.url, config.user, config.password, execCtx)
}
