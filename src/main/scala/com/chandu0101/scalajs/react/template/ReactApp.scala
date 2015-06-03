package com.chandu0101.scalajs.react.template

import com.chandu0101.scalajs.react.template.css.AppCSS
import com.chandu0101.scalajs.react.template.router.AppRouter
import japgolly.scalajs.react.{React, _}
import japgolly.scalajs.react.vdom.all._
import org.scalajs.dom
import org.scalajs.dom.html
import org.scalajs.dom.html.Input

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._
import scala.scalajs.js
import scalacss.Defaults._
import scalacss.ScalaCssReact._


object ReactApp extends JSApp {
  @JSExport
  override def main(): Unit = {
    AppCSS.load
   AppRouter.router().render(dom.document.body)
  }

}

