package ag.rob.reference.service1.ui.client

import ag.rob.reference.service1.ui.client.CssSettings._
import ag.rob.reference.service1.ui.client.Main.Page
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._
import typings.antd.components.Button
import typings.fortawesomeProSolidSvgIcons.{mod => fas}
import typings.fortawesomeReactFontawesome.components.FontAwesomeIcon

object Home extends Page {
  val Component = ScalaComponent
    .builder[Unit]("home")
    .renderStatic(<.div(styles.red,
      Button()("moin", FontAwesomeIcon(fas.faAnchor)())
    ))
    .build

  object styles extends StyleSheet.Inline {

    import dsl._

    val red = style(
      color.red
    )
  }
}
