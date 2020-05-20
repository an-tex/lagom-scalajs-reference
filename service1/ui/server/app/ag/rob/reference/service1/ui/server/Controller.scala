package ag.rob.reference.service1.ui.server

import javax.inject._
import play.api.mvc._

@Singleton
class Controller @Inject()(val controllerComponents: ControllerComponents) extends BaseController {
  def indexRoot = index("")

  def index(path: String) = Action { implicit request: Request[AnyContent] =>
    Ok(html.main(jsUrl(isLibrary = true), jsUrl(isLibrary = false)))
  }

  def jsUrl(isLibrary: Boolean): String = {
    val name = "service1uiclient"
    val append = if (isLibrary) "-library" else ""
    Seq(s"$name-opt$append.js", s"$name-fastopt$append.js")
      .find(name => getClass.getResource(s"/public/$name") != null)
      .map(controllers.routes.Assets.versioned(_).url).get
  }
}
