package scalajsreact.template.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object Footer {

  val component = ReactComponentB.static("Footer",
    <.footer(^.textAlign.center,
    <.div(^.borderBottom := "1px solid grey", ^.padding := "0px"),
    <.p(^.paddingTop := "5px", "Built using scalajs/scalajs-react/scalacss")
    )
  ).buildU

  def apply() = component()
}
