package com.chandu0101.scalajs.react.template.css

import scalacss.Defaults._

object GlobalStyle extends StyleSheet.Inline {

  import dsl._

  style(unsafeRoot("body")(
    margin.`0`,
    padding.`0`,
    fontSize(14.px),
    fontFamily := "Roboto, sans-serif"
  ))
}
