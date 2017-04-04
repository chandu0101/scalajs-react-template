package scalajsreact.template.css

import scalacss.Defaults._
import scalacss.internal.mutable.GlobalRegistry
import scalajsreact.template.components.{LeftNav, TopNav}
import scalajsreact.template.pages.{HomePage, ItemsPage}

object AppCSS {

  def load = {
    GlobalRegistry.register(GlobalStyle,
                            TopNav.Style,
                            LeftNav.Style,
                            ItemsPage.Style,
                            HomePage.Style)
    GlobalRegistry.onRegistration(_.addToDocument())
  }
}
