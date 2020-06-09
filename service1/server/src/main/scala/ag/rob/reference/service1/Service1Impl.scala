package ag.rob.reference.service1

import ag.rob.reference.service1.api.Service1Api
import ag.rob.reference.service1.api.Service1Api.RandomValue.{RandomDouble, RandomLong, RandomString}
import ag.rob.reference.service2.api.Service2Api
import akka.actor.typed.scaladsl.AskPattern._
import akka.actor.typed.{ActorRef, ActorSystem}
import akka.util.Timeout
import com.lightbend.lagom.scaladsl.api.ServiceCall
import io.scalaland.chimney.dsl._

import scala.concurrent.duration._
import scala.util.Random

class Service1Impl(
                    pingActor: ActorRef[PingActor.Command],
                    service2Api: Service2Api,
                    implicit val actorSystem: ActorSystem[_]
                  ) extends Service1Api {
  implicit val timeout = Timeout(1.second)

  import actorSystem.executionContext

  override def ping = ServiceCall { _ =>
    pingActor
      .ask[PingActor.Pong](replyTo => PingActor.Ping(replyTo))
      .map(_.into[Service1Api.Pong].transform)
  }

  override def random = ServiceCall { _ =>
    service2Api.random.invoke().map(randomValues =>
      Random.nextInt(3) match {
        case 0 => RandomString(randomValues.string)
        case 1 => RandomLong(randomValues.long)
        case 2 => RandomDouble(randomValues.double)
      }
    )
  }
}
