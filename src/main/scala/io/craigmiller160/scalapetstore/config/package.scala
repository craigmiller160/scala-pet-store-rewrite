package io.craigmiller160.scalapetstore

import io.circe.Decoder
import io.circe.generic.semiauto._

package object config {
  implicit val appConfigDecoder: Decoder[AppConfig] = deriveDecoder
  implicit val dbConfigDecoder: Decoder[DatabaseConfig] = deriveDecoder
  implicit val serverConfigDecoder: Decoder[ServerConfig] = deriveDecoder
}
