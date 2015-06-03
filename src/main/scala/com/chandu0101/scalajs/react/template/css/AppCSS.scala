package com.chandu0101.scalajs.react.template.css

import com.chandu0101.scalajs.react.template.components.{LeftNav, TopNav}
import com.chandu0101.scalajs.react.template.pages.{HomePage, ItemsPage}

import scalacss.ScalaCssReact._
import scalacss.mutable.GlobalRegistry
import scalacss.Defaults._

object AppCSS {

  def load = {
    GlobalRegistry.register(
      GlobalStyle,
      TopNav.Style,
      LeftNav.Style,
      ItemsPage.Style,
      HomePage.Style)
    GlobalRegistry.onRegistration(_.addToDocument())
  }
}

