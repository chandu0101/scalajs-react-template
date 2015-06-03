package scalajsreact.template.components.items

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object Item1Data {

  val component = ReactComponentB.static("Item1",
    <.div("This is Item1 Page ")
  ).buildU

  def apply() = component()
}
