package com.chandu0101.scalajs.react.template.components

import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.Reusability
import japgolly.scalajs.react.vdom.all._

import scala.scalajs.js


object ResusabilityExample {


  class Backend(t: BackendScope[Props, _]) {


  }

  case class ChickType(name : String)
  case class Props(name: String, age: Int,chiks : Vector[ChickType])

 implicit val chicksReUse = Reusability.by_==[Vector[ChickType]]
  implicit val propReuse = Reusability.caseclass3(Props.unapply)

  val component = ReactComponentB[Props]("ResusabilityExample")
    .stateless
    .backend(new Backend(_))
    .render((P, S, B) => {
    div(
      h1("Name : ", P.name),
      h3("Age : ", P.age)
    )
  })
    .configure(Reusability.shouldComponentUpdateWithOverlay)
    .build



  def apply(ref: js.UndefOr[String] = "", key: js.Any = {}, props: Props = Props("Dude", 24,Vector(ChickType("dude")))) = component.set(key, ref)(props)
}
