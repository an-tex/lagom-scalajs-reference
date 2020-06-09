package ag.rob.reference.service1.ui.client

import ag.rob.reference.service1.api.Service1Api.Pong
import ag.rob.reference.service1.ui.client.CssSettings._
import ag.rob.reference.service1.ui.client.Main.Page
import ag.rob.reference.service1.ui.client.RootModel.Ping
import diode.data.Pot
import diode.react.ModelProxy
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._
import typings.antd.components.Button
import typings.fortawesomeProSolidSvgIcons.{mod => fas}
import typings.fortawesomeReactFontawesome.components.FontAwesomeIcon

object Home extends Page {
  private val component = ScalaComponent
    .builder[ModelProxy[Pot[Pong]]]("home")
    .render_P { proxy =>
      <.div(styles.red,
        <.div(
          Button(onClick = _ => proxy.dispatchCB(Ping()))("Ping ", FontAwesomeIcon(fas.faAnchor)()),
        ),
        <.div(
          "Pong: ",
          proxy().toString
        )
      )
    }
    .build

  private val connector = Circuit.connect(_.pong)

  def apply() = connector(component(_))

  object styles extends StyleSheet.Inline {

    import dsl._

    val red = style(
      color.red
    )
  }
}
