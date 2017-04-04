package scalajsreact.template

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import scalajsreact.template.css.AppCSS
import scalajsreact.template.routes.AppRouter

import org.scalajs.dom

object ReactApp extends JSApp {

  @JSExport
  override def main(): Unit = {
    AppCSS.load
    AppRouter.router().renderIntoDOM(dom.document.body)
  }

}
