package ag.rob.reference.service2.api

import ag.rob.reference.circelagom.JsonMessageSerializer._
import ag.rob.reference.service2.api.Service2Api.RandomValues
import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import io.circe.Codec
import io.circe.generic.semiauto._

trait Service2Api extends Service {

  def random: ServiceCall[NotUsed, RandomValues]

  override final def descriptor: Descriptor = {
    import Service._
    named("service2")
      .withCalls(
        pathCall("/api/random", random _),
      )
      .withAutoAcl(true)
  }
}

object Service2Api {
  case class RandomValues(
                           string: String,
                           long: Long,
                           double: Double
                         )

  object RandomValues {
    implicit val codec: Codec[RandomValues] = deriveCodec
  }
}
