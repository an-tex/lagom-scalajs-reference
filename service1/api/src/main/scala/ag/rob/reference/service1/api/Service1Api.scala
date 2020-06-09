package ag.rob.reference.service1.api

import ag.rob.reference.circelagom.JsonMessageSerializer._
import ag.rob.reference.service1.api.Service1Api.Pong
import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.transport.Method
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}
import io.circe.Codec
import io.circe.generic.semiauto._

trait Service1Api extends Service {

  def ping: ServiceCall[NotUsed, Pong]

  override final def descriptor: Descriptor = {
    import Service._
    named("service1")
      .withCalls(
        restCall(Method.GET, "/api/ping", ping _),
      )
      .withAutoAcl(true)
  }
}

object Service1Api {
  case class Pong(counter: Int)

  implicit val pongCodec: Codec[Pong] = deriveCodec
}
