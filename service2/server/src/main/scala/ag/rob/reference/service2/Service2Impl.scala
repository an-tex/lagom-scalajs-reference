package ag.rob.reference.service2

import ag.rob.reference.service2.api.Service2Api
import com.lightbend.lagom.scaladsl.api.ServiceCall

import scala.concurrent.Future

class Service2Impl extends Service2Api {
  override def hello2(id: String) = ServiceCall { _ =>
    Future.successful(s"moin2 $id")
  }
}
