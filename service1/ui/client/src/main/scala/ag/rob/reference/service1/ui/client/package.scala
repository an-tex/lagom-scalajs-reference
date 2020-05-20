package ag.rob.reference.service1.ui

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

package object client {
  val CssSettings = scalacss.devOrProdDefaults

  @JSImport("antd/dist/antd.less", JSImport.Namespace)
  @js.native
  object AntdLess extends js.Object
}
