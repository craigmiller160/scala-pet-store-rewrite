package io.craigmiller160.scalapetstore.config

case class DatabaseConfig(
                           url: String,
                           driver: String,
                           user: String,
                           password: String,
                           connections: DatabaseConnectionsConfig,
                         )
