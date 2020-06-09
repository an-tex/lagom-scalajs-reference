package ag.rob.reference.service1.ui.client

import ag.rob.reference.service1.api.Service1Api.{Pong, RandomValue}
import ag.rob.reference.service1.ui.client.CssSettings._
import ag.rob.reference.service1.ui.client.Main.Page
import ag.rob.reference.service1.ui.client.RootModel.{GenerateRandomValue, Ping}
import diode.UseValueEq
import diode.data.Pot
import diode.react.ModelProxy
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalacss.ScalaCssReact._
import typings.antd.components.Button
import typings.fortawesomeProSolidSvgIcons.{mod => fas}
import typings.fortawesomeReactFontawesome.components.FontAwesomeIcon

object Home extends Page {
  case class ProxyProps(pong: Pot[Pong], randomValue: Pot[RandomValue]) extends UseValueEq

  private val component = ScalaComponent
    .builder[ModelProxy[ProxyProps]]("home")
    .render_P { proxy =>
      <.div(
        <.div(styles.red,
          <.div(
            Button(onClick = _ => proxy.dispatchCB(Ping()))("Ping ", FontAwesomeIcon(fas.faAnchor)()),
          ),
          <.div(
            "Pong: ",
            proxy().pong.toString
          )
        ),
        <.div(
          <.div(
            Button(onClick = _ => proxy.dispatchCB(GenerateRandomValue()))("Random", FontAwesomeIcon(fas.faAnchor)()),
          ),
          <.div(
            "Random: ",
            proxy().randomValue.toString
          )
        )
      )
    }
    .build

  private val connector = Circuit.connect(rootModel => ProxyProps(rootModel.pong, rootModel.randomValue))

  def apply() = connector(component(_))

  object styles extends StyleSheet.Inline {

    import dsl._

    val red = style(
      color.red
    )
  }
}
