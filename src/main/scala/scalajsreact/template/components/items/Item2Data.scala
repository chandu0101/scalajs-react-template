package scalajsreact.template.components.items

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object Item2Data {

   val component = ReactComponentB.static("Item2",
     <.div("This is Item2 Page ")
   ).buildU

   def apply() = component()
 }
