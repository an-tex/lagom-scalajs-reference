package ag.rob.reference.service1.ui.client

import java.net.URI

import ag.rob.reference.service1.api.Service1Api
import com.lightbend.lagom.scaladsl.client.{StandaloneLagomClientFactory, StaticServiceLocatorComponents}
import org.scalajs.dom.window

class ClientApplication(
                         hostname: String = window.location.hostname,
                         protocol: String = window.location.protocol
                       )
  extends StandaloneLagomClientFactory("client")
    with StaticServiceLocatorComponents {
  override def staticServiceUri = URI.create(
    if (hostname == "localhost") "http://localhost:59714"
    else s"$protocol//$hostname"
  )
}

object ApiClient {
  val application = new ClientApplication()
  val service1Api = application.serviceClient.implement[Service1Api]
}