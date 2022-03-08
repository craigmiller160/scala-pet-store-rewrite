package io.craigmiller160.scalapetstore.config

import cats.effect._
import doobie.util.ExecutionContexts

import scala.concurrent.ExecutionContext

case class ExecContextConfig(
                              serverCtx: ExecutionContext,
                              dbCtx: ExecutionContext
                            )
object ExecContextConfig {
  def executionContexts[F[_]: Async](config: AppConfig): Resource[F, ExecContextConfig] =
    for {
      serverCtx <- ExecutionContexts.cachedThreadPool[F]
      dbCtx <- ExecutionContexts.fixedThreadPool[F](config.db.poolSize)
    } yield ExecContextConfig(serverCtx, dbCtx)
}
