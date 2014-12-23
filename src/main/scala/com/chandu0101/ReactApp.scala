package com.chandu0101

import com.chandu0101.router.AppRouter
import japgolly.scalajs.react.React
import org.scalajs.dom

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

/**
 * Created by chandrasekharkode on 12/23/14.
 */
object ReactApp  extends JSApp{
  @JSExport
  override def main(): Unit = React.render(AppRouter.C() ,dom.document.body)
}
