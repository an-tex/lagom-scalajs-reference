package ag.rob.reference.service1.ui.server

import _root_.controllers.AssetsComponents
import _root_.router.Routes
import com.softwaremill.macwire._
import play.api.ApplicationLoader.Context
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.routing.Router
import play.api.{ApplicationLoader, BuiltInComponentsFromContext, Mode}
import play.filters.HttpFiltersComponents

class Loader extends ApplicationLoader {
  override def load(context: Context): play.api.Application = context.environment.mode match {
    case Mode.Dev => new Application(context).application
    case _ => new Application(context).application
  }
}

class Application(context: Context)
  extends BuiltInComponentsFromContext(context)
    with AssetsComponents
    with HttpFiltersComponents
    with AhcWSComponents {

  override lazy val router: Router = {
    // used by wire
    val prefix = "/"
    wire[Routes]
  }
  lazy val controller = wire[Controller]
}
