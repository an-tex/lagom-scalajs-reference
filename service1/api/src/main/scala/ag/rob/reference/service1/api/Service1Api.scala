package ag.rob.reference.service1.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

trait Service1Api extends Service {

  def hello1(id: String): ServiceCall[NotUsed, String]

  override final def descriptor: Descriptor = {
    import Service._
    named("service1")
      .withCalls(
        pathCall("/api/hello1/:id", hello1 _),
      )
      .withAutoAcl(true)
  }
}
