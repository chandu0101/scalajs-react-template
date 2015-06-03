package com.chandu0101.scalajs.react.template.pages


import com.chandu0101.scalajs.react.template.components.ResusabilityExample
import com.chandu0101.scalajs.react.template.components.ResusabilityExample.ChickType
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js


object ReusabilityPage {

  case class State(name: String,age : Int,chiks : Vector[ChickType])

  class Backend(t: BackendScope[_, State]) {

    def changeState = {
      t.modState(s => s.copy("Dude",24,Vector(ChickType("dude"))))
    }
  }

  val component = ReactComponentB[Unit]("ReusabilityPage")
    .initialState(State("Dude",24,Vector(ChickType("dude"))))
    .backend(new Backend(_))
    .render((P, S, B) => {
      div(
        a(onClick --> B.changeState ,cursor := "pointer")("Click Me"),
        ResusabilityExample(props = ResusabilityExample.Props(S.name,S.age,S.chiks))
      )
    })
    .buildU


  def apply() = component()

}
