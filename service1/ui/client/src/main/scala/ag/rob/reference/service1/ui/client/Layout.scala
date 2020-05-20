package ag.rob.reference.service1.ui.client

import ag.rob.reference.service1.ui.client.CssSettings._
import ag.rob.reference.service1.ui.client.Main.Page
import japgolly.scalajs.react.extra.router.{Resolution, RouterCtl}
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._
import scalacss.internal.mutable.GlobalRegistry

object Layout extends Page {
  def render(routerCtrl: RouterCtl[Main.Page], resolution: Resolution[Main.Page]) = {
    <.div(styles.background,
      resolution.render()
    )
  }

  object styles extends StyleSheet.Inline {

    import dsl._

    val background = style(
      backgroundColor.green
    )
  }
}
