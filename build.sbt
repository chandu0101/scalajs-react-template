val v = new {
  val app = "1.0"
  val scala = "2.12.8"
  val scalaJSDom = "0.9.7"
  val scalaJSReact = "1.4.2"
  val scalaCss = "0.5.6"
  val reactJS = "16.8.6"
}

name := "scalajs-react-template"
version := v.app
scalaVersion := v.scala

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % v.scalaJSDom,
  "com.github.japgolly.scalajs-react" %%% "core" % v.scalaJSReact,
  "com.github.japgolly.scalajs-react" %%% "extra" % v.scalaJSReact,
  "com.github.japgolly.scalacss" %%% "core" % v.scalaCss,
  "com.github.japgolly.scalacss" %%% "ext-react" % v.scalaCss
)


enablePlugins(ScalaJSPlugin)
(scalaJSUseMainModuleInitializer in Compile) := true

// creates single js resource file for easy integration in html page
skip in packageJSDependencies := false

// copy  javascript files to js folder,that are generated using fastOptJS/fullOptJS
crossTarget in (Compile, fullOptJS) := file("js")
crossTarget in (Compile, fastOptJS) := file("js")
crossTarget in (Compile, packageJSDependencies) := file("js")
crossTarget in (Compile, packageMinifiedJSDependencies) := file("js")
artifactPath in (Compile, fastOptJS) := ((crossTarget in (Compile, fastOptJS)).value /
  ((moduleName in fastOptJS).value + "-opt.js"))
scalacOptions += "-feature"


enablePlugins(JSDependenciesPlugin)
jsDependencies ++= Seq(
  "org.webjars.npm" % "react" % v.reactJS
    /        "umd/react.development.js"
    minified "umd/react.production.min.js"
    commonJSName "React",
  "org.webjars.npm" % "react-dom" % v.reactJS
    /         "umd/react-dom.development.js"
    minified  "umd/react-dom.production.min.js"
    dependsOn "umd/react.development.js"
    commonJSName "ReactDOM",
  "org.webjars.npm" % "react-dom" % v.reactJS
    /         "umd/react-dom-server.browser.development.js"
    minified  "umd/react-dom-server.browser.production.min.js"
    dependsOn "umd/react-dom.development.js"
    commonJSName "ReactDOMServer"
)

//enablePlugins(ScalaJSBundlerPlugin)
//npmDependencies in Compile ++= Seq(
//)

// fixes unresolved deps issue: https://github.com/webjars/webjars/issues/1789
dependencyOverrides ++= Seq(
  "org.webjars.npm" % "js-tokens" % "4.0.0",
  "org.webjars.npm" % "scheduler" % "0.14.0"
)


//enablePlugins(WorkbenchPlugin)
// Live Reloading: WorkbenchPlugin must NOT be enabled at the same time
enablePlugins(WorkbenchSplicePlugin)
workbenchCompression := true
workbenchStartMode := WorkbenchStartModes.OnCompile
