package ag.rob.reference.service2

import ag.rob.reference.service2.api.Service2Api
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server.{LagomApplication, LagomApplicationContext, LagomApplicationLoader, LagomServer}
import com.softwaremill.macwire.wire
import play.api.libs.ws.ahc.AhcWSComponents

class Service2Loader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new Service2Application(context) {
      override def serviceLocator: NoServiceLocator.type = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new Service2Application(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[Service2Api])
}

abstract class Service2Application(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {

  override lazy val lagomServer: LagomServer = serverFor[Service2Api](wire[Service2Impl])
}
