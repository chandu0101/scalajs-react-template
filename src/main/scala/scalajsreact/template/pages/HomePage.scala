package scalajsreact.template.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scalacss.Defaults._
import scalacss.ScalaCssReact._

object HomePage {

  object Style extends StyleSheet.Inline {
    import dsl._
    val content = style(textAlign.center,
      fontSize(30.px),
      minHeight(450.px),
      paddingTop(40.px))
  }

  val component = ReactComponentB.static("HomePage",
    <.div(Style.content, "ScalaJS-React Template ")
  ).buildU

  def apply() = component()
}
