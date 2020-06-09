package ag.rob.reference.service1.ui.client

import ag.rob.reference.service1.api.Service1Api.{Pong, RandomValue}
import ag.rob.reference.service1.ui.client.RootModel.{GenerateRandomValue, Ping}
import diode.ActionHandler
import diode.data.{Empty, Pot, PotAction}
import diode.react.ReactConnector

import scala.concurrent.ExecutionContext.Implicits.global

case class RootModel(pong: Pot[Pong] = Pot.empty[Pong], randomValue: Pot[RandomValue] = Pot.empty[RandomValue])

object RootModel {
  case class Ping(potResult: Pot[Pong] = Empty) extends PotAction[Pong, Ping] {
    override def next(newResult: Pot[Pong]) = Ping(newResult)
  }

  case class GenerateRandomValue(potResult: Pot[RandomValue] = Empty) extends PotAction[RandomValue, GenerateRandomValue] {
    override def next(newResult: Pot[RandomValue]) = GenerateRandomValue(newResult)
  }
}

object Circuit extends diode.Circuit[RootModel] with ReactConnector[RootModel] {
  override protected def initialModel = RootModel()

  val pingHandler = new ActionHandler(zoomTo(_.pong)) {
    override protected def handle = {
      case action: Ping =>
        action.handleWith(
          this,
          action.effect(ApiClient.service1Api.ping.invoke())(identity)
        )(PotAction.handler())
    }
  }

  val generateRandomValueHandler = new ActionHandler(zoomTo(_.randomValue)) {
    override protected def handle = {
      case action: GenerateRandomValue =>
        action.handleWith(
          this,
          action.effect(ApiClient.service1Api.random.invoke())(identity)
        )(PotAction.handler())
    }
  }

  override protected def actionHandler = composeHandlers(pingHandler, generateRandomValueHandler)
}
