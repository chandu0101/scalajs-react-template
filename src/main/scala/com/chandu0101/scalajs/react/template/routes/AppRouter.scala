package com.chandu0101.scalajs.react.template.routes

import com.chandu0101.scalajs.react.template.components.{TopNav, Footer}
import com.chandu0101.scalajs.react.template.models.Menu
import com.chandu0101.scalajs.react.template.pages.HomePage
import com.chandu0101.scalajs.react.template.routes.Item.Info
import japgolly.scalajs.react.extra.router2.{Resolution, RouterConfigDsl, RouterCtl, _}
import japgolly.scalajs.react.vdom.prefix_<^._


object AppRouter {

  sealed trait AppPage

  case object Home extends AppPage
  case class Items(p : Item) extends AppPage


  val config = RouterConfigDsl[AppPage].buildConfig { dsl =>
    import dsl._
    val itemRoutes : Rule = Item.routes.prefixPath_/("#items").pmap[AppPage](Items){ case Items(p) => p}
    (trimSlashes
      | staticRoute(root, Home) ~> render(HomePage())
      | itemRoutes
      ).notFound(redirectToPage(Home)(Redirect.Replace))
      .renderWith(layout)
  }


  val mainMenu = Vector(
   Menu("Home",Home),
   Menu("Items",Items(Info))
  )


  def layout(c: RouterCtl[AppPage], r: Resolution[AppPage]) = {
    <.div(
      TopNav(TopNav.Props(mainMenu,r.page,c)),
      r.render(),
      Footer()
    )
  }

  val baseUrl = BaseUrl.fromWindowOrigin / "scalajs-react-template/"

  val router = Router(baseUrl, config)

}
