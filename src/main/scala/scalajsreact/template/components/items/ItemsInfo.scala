package scalajsreact.template.components.items

import japgolly.scalajs.react.{ReactComponentB, _}
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._
import scalacss.ScalaCssReact._

object ItemsInfo {

  val component = ReactComponentB.static("ItemsInfo",
    <.div(" Items Root Page  ")
  ).buildU

  def apply() = component()
}
