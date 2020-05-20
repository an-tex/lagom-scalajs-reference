package ag.rob.reference.service1

import ag.rob.reference.service1.api.Service1Api
import com.lightbend.lagom.scaladsl.api.ServiceLocator.NoServiceLocator
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.lightbend.lagom.scaladsl.server._
import com.softwaremill.macwire._
import play.api.libs.ws.ahc.AhcWSComponents

class Service1Loader extends LagomApplicationLoader {

  override def load(context: LagomApplicationContext): LagomApplication =
    new Service1Application(context) {
      override def serviceLocator: NoServiceLocator.type = NoServiceLocator
    }

  override def loadDevMode(context: LagomApplicationContext): LagomApplication =
    new Service1Application(context) with LagomDevModeComponents

  override def describeService = Some(readDescriptor[Service1Api])
}

abstract class Service1Application(context: LagomApplicationContext)
  extends LagomApplication(context)
    with AhcWSComponents {

  override lazy val lagomServer: LagomServer = serverFor[Service1Api](wire[Service1Impl])
}
