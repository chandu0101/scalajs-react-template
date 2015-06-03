package scalajsreact.template.css

import scalajsreact.template.components.{TopNav, LeftNav}
import scalajsreact.template.pages.{HomePage, ItemsPage}
import TopNav.Style

import scalacss.ScalaCssReact._
import scalacss.mutable.GlobalRegistry
import scalacss.Defaults._

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
