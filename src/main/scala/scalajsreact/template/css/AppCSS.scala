package scalajsreact.template.css

import com.chandu0101.scalajs.react.template.components.TopNav
import com.chandu0101.scalajs.react.template.pages.ItemsPage

import scalacss.ScalaCssReact._
import scalacss.mutable.GlobalRegistry
import scalacss.Defaults._
import scalajsreact.template.components.{TopNav, LeftNav}
import TopNav.Style
import scalajs.react.template.pages.ItemsPage
import scalajsreact.template.components.LeftNav
import scalajsreact.template.components.TopNav.Style
import scalajsreact.template.pages.{HomePage, ItemsPage}

object AppCSS {

  def load = {
    GlobalRegistry.register(
      GlobalStyle,
      Style,
      LeftNav.Style,
      ItemsPage.Style,
      HomePage.Style)
    GlobalRegistry.onRegistration(_.addToDocument())
  }
}

