package scalajsreact.template.pages

import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalajsreact.template.components.LeftNav
import scalajsreact.template.routes.Item

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._

object ItemsPage {

  object Style extends StyleSheet.Inline {
    import dsl._
    val container = style(display.flex, minHeight(600.px))

    val nav =
      style(width(190.px), borderRight :=! "1px solid rgb(223, 220, 220)")

    val content = style(padding(30.px))
  }

  val component = ScalaComponent
    .builder[Props]("ItemsPage")
    .render_P { P =>
      <.div(
        Style.container,
        <.div(Style.nav,
              LeftNav(LeftNav.Props(Item.menu, P.selectedPage, P.ctrl))),
        <.div(Style.content, P.selectedPage.render())
      )
    }
    .build

  case class Props(selectedPage: Item, ctrl: RouterCtl[Item])

  def apply(props: Props) = component(props).vdomElement

}
