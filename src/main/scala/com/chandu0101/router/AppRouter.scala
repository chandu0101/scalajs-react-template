package com.chandu0101.router

import japgolly.scalajs.react.{ReactElement, ReactComponentB}
import japgolly.scalajs.react.extras.router.{BaseUrl, Redirect, Page}
import japgolly.scalajs.react._, vdom.prefix_<^._
/**
 * Created by chandrasekharkode on 12/23/14.
 */
object AppRouter {

  object AppPage extends Page {

    // *************
    // Static Routes
    // *************

    val root = register(rootLocation(RootComponent))
    val hello: Loc = register(location("/hello", HelloComponent))

    register(redirection("/hey", hello, Redirect.Replace))

    // *******
    // General
    // *******

    register(removeTrailingSlashes)

    override protected val notFound = redirect(root, Redirect.Replace)

    override protected def interceptRender(i: InterceptionR): ReactElement =
      if (i.loc == root)
        i.element
      else
        <.div(
          <.div(i.router.link(root)("Back", ^.cls := "back")),
          i.element)

  }

  val RootComponent = ReactComponentB[AppPage.Router]("Root")
    .render(router =>
    <.div(
      <.p("This is the root page. Click on a link below to view routes within this page."),
      <.div(router.link(AppPage.hello)("The 'hello' route", ^.cls := "hello")))
    ).build

  val HelloComponent = ReactComponentB[Unit]("Hello")
    .render(_ => <.h3("Hello there!"))
    .buildU


  val C = AppPage.router(BaseUrl.fromWindow / "scalajs-react-template")

}
