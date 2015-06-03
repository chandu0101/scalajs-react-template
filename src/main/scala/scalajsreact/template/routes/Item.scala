package scalajsreact.template.routes

import japgolly.scalajs.react.ReactElement
import japgolly.scalajs.react.extra.router2.RouterConfigDsl

import scalajsreact.template.components.Footer
import scalajsreact.template.components.items.{ItemsInfo, Item1Data, Item2Data}
import scalajsreact.template.pages.ItemsPage

sealed abstract class Item(val title: String,
val routerPath: String,
val render: () => ReactElement)


object Item {

  case object Info extends Item("Info","info",() => ItemsInfo())

  case object Item1 extends Item("Item1","item1",() => Item1Data())

  case object Item2 extends Item("Item2","item2",() => Item2Data())

  val menu = Vector(Info,Item1,Item2)

  val routes = RouterConfigDsl[Item].buildRule { dsl =>
    import dsl._

    menu.map(i =>
      staticRoute(i.routerPath, i) ~> renderR(r => ItemsPage(props = ItemsPage.Props(i, r)))
    ).reduce(_ | _)

  }

}
