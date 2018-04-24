package scalajsreact.template

import japgolly.scalajs.react.ReactDOM
import scalajsreact.template.css.AppCSS
import scalajsreact.template.routes.AppRouter
import org.scalajs.dom

import scala.scalajs.js.annotation.JSExport

object ReactApp {

  @JSExport
  def main(args: Array[String]): Unit = {
    AppCSS.load
    AppRouter.router().renderIntoDOM(dom.document.getElementById("template-app"))
  }

}
