package ag.rob.reference.service1

import akka.actor.typed.ActorRef
import akka.actor.typed.scaladsl.Behaviors

object PingActor {
  sealed trait Command
  case class Ping(replyTo: ActorRef[Pong]) extends Command
  case class Pong(counter: Int)

  def apply() = Behaviors.setup[Command] { _ =>
    def withCounter(counter: Int): Behaviors.Receive[Command] = Behaviors.receiveMessage {
      case Ping(replyTo) =>
        replyTo ! Pong(counter)
        withCounter(counter + 1)
    }

    withCounter(0)
  }
}
