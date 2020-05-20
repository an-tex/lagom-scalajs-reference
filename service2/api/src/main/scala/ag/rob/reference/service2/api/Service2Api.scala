package ag.rob.reference.service2.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait Service2Api extends Service {

  def hello2(id: String): ServiceCall[NotUsed, String]

  override final def descriptor: Descriptor = {
    import Service._
    named("service2")
      .withCalls(
        pathCall("/api/hello2/:id", hello2 _),
      )
      .withAutoAcl(true)
  }
}
