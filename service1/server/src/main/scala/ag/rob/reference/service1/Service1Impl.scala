package ag.rob.reference.service1

import ag.rob.reference.service1.api.Service1Api
import akka.actor.typed.scaladsl.AskPattern._
import akka.actor.typed.{ActorRef, ActorSystem}
import akka.util.Timeout
import com.lightbend.lagom.scaladsl.api.ServiceCall
import io.scalaland.chimney.dsl._

import scala.concurrent.duration._

class Service1Impl(
                    pingActor: ActorRef[PingActor.Command],
                    implicit val actorSystem: ActorSystem[_]
                  ) extends Service1Api {
  implicit val timeout = Timeout(1.second)

  import actorSystem.executionContext

  override def ping = ServiceCall { _ =>
    pingActor
      .ask[PingActor.Pong](replyTo => PingActor.Ping(replyTo))
      .map(_.into[Service1Api.Pong].transform)
  }
}
