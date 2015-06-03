package scalajsreact.template.components

import scalajsreact.template.routes.AppRouter
import AppRouter.AppPage
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.extra.router2.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalajsreact.template.routes.AppRouter
import AppRouter.AppPage
import scalajsreact.template.models.Menu
import scalajsreact.template.routes.AppRouter.AppPage


object TopNav {

  object Style extends StyleSheet.Inline {

    import dsl._

    val navMenu = style(display.flex,
      alignItems.center,
      backgroundColor("#F2706D"),
      margin.`0`,
      listStyle := "none")

    val menuItem = boolStyle(selected => styleS(
      padding(20.px),
      fontSize(1.5.em),
      cursor.pointer,
      color("rgb(244, 233, 233)"),
      mixinIfElse(selected)(
        backgroundColor("#E8433F".color),
        fontWeight._500)
        (&.hover(
              backgroundColor("#B6413E".color)))
    ))

  }

  case class Props(menus: Vector[Menu], selectedPage: AppPage, ctrl: RouterCtl[AppPage])

  implicit val currentPageReuse = Reusability.by_==[AppPage]
  implicit val propsReuse = Reusability.by((_:Props).selectedPage)

  val component = ReactComponentB[Props]("TopNav")
    .render((P) => {
    <.header(
      <.nav(
        <.ul(Style.navMenu,
          P.menus.map(item => <.li(^.key := item.name, Style.menuItem(item.route == P.selectedPage), item.name, P.ctrl setOnClick item.route)))
      ))
  })
    .configure(Reusability.shouldComponentUpdate)
    .build

  def apply(props: Props, ref: js.UndefOr[String] = "", key: js.Any = {}) = component.set(key, ref)(props)

}


