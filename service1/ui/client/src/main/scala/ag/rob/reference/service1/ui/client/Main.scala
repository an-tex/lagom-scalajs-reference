package ag.rob.reference.service1.ui.client

import ag.rob.reference.service1.ui.client.CssSettings._
import japgolly.scalajs.react.extra.router.SetRouteVia.HistoryReplace
import japgolly.scalajs.react.extra.router.{BaseUrl, Router, RouterConfigDsl}
import org.scalajs.dom
import scalacss.internal.mutable.GlobalRegistry

object Main {
  trait Page

  private val routerConfig = RouterConfigDsl[Page].buildConfig { dsl =>
    import dsl._
    (
      staticRoute(root, Home) ~> render(Home())
      )
      .notFound(redirectToPage(Home)(HistoryReplace))
      .renderWith(Layout.render)
  }

  GlobalRegistry.register(
    Layout.styles,
    Home.styles
  )

  AntdLess

  def main(args: Array[String]): Unit = {
    GlobalRegistry.addToDocumentOnRegistration()

    val router = Router(BaseUrl.fromWindowOrigin, routerConfig)
    router().renderIntoDOM(dom.document.getElementById("moinMusicRoot"))
  }
}
