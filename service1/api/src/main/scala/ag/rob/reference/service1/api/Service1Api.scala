package ag.rob.reference.service1.api

import ag.rob.reference.circelagom.JsonMessageSerializer._
import ag.rob.reference.service1.api.Service1Api.{Pong, RandomValue}
import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import io.circe.Codec
import io.circe.generic.semiauto._

trait Service1Api extends Service {

  def ping: ServiceCall[NotUsed, Pong]

  def random: ServiceCall[NotUsed, RandomValue]

  override final def descriptor: Descriptor = {
    import Service._
    named("service1")
      .withCalls(

        restCall(Method.GET, "/api/ping", ping _),
        restCall(Method.GET, "/api/random", random _),
      )
      .withAutoAcl(true)
  }
}

object Service1Api {
  case class Pong(counter: Int)
  object Pong {
    implicit val codec: Codec[Pong] = deriveCodec
  }

  sealed trait RandomValue

  object RandomValue {
    case class RandomString(value: String) extends RandomValue
    case class RandomLong(value: Long) extends RandomValue
    case class RandomDouble(value: Double) extends RandomValue

    implicit val codec: Codec[RandomValue] = deriveCodec
  }
}
