package ag.rob.reference.service1

import ag.rob.reference.service1.api.Service1Api
import com.lightbend.lagom.scaladsl.api.ServiceCall

import scala.concurrent.Future

class Service1Impl extends Service1Api {
  override def hello1(id: String) = ServiceCall { _ =>
    Future.successful(s"moin1 $id")
  }
}
