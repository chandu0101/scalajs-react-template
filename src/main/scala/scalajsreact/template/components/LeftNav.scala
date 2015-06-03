package scalajsreact.template.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.extra.router2.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js.{Any, UndefOr}
import scalacss.Defaults._
import scalacss.ScalaCssReact._
import scalajsreact.template.routes.Item

object LeftNav {

  object Style extends StyleSheet.Inline {

    import dsl._

    val container = style(display.flex,
      flexDirection.column,
      listStyle := "none",
      padding.`0`
    )

    val menuItem = boolStyle(selected => styleS(
      lineHeight(48.px),
      padding :=! "0 25px",
      cursor.pointer,
      textDecoration := "none",
      mixinIfElse(selected)(color.red,
        fontWeight._500)
        (color.black,
            &.hover(color("#555555".color),
              backgroundColor("#ecf0f1".color)))
    ))
  }

  case class Props(menus: Vector[Item], selectedPage: Item, ctrl: RouterCtl[Item])

  implicit val currentPageReuse = Reusability.by_==[Item]
  implicit val propsReuse = Reusability.by((_: Props).selectedPage)

  val component = ReactComponentB[Props]("LeftNav")
    .render(P => {
    <.ul(Style.container)(
      P.menus.map(item => <.li(^.key := item.title,
        Style.menuItem(item == P.selectedPage),
        item.title,
        P.ctrl setOnClick item))
    )
  })
    .configure(Reusability.shouldComponentUpdate)
    .build


  def apply(props: Props, ref: UndefOr[String] = "", key: Any = {}) = component.set(key, ref)(props)

}
