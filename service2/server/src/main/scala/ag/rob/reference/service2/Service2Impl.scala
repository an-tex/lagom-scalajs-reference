package ag.rob.reference.service2

import ag.rob.reference.service2.api.Service2Api
import ag.rob.reference.service2.api.Service2Api.RandomValues
import com.lightbend.lagom.scaladsl.api.ServiceCall

import scala.concurrent.Future
import scala.util.Random

class Service2Impl extends Service2Api {
  override def random = ServiceCall { _ =>
    Future.successful(RandomValues(
      Random.alphanumeric.take(8).mkString,
      Random.nextLong(),
      Random.nextDouble()
    ))
  }
}
