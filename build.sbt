enablePlugins(ScalaJSPlugin)

name := "scalajs-react-template"

version := "1.0"

scalaVersion := "2.11.7"


// create launcher file ( its search for object extends JSApp , make sure there is only one file)
persistLauncher := true

persistLauncher in Test := false

val scalaJSReactVersion = "0.10.1"

val scalaCssVersion = "0.3.1"

val reactJSVersion = "0.14.2"


libraryDependencies ++= Seq("com.github.japgolly.scalajs-react" %%% "core" % scalaJSReactVersion,
  "com.github.japgolly.scalajs-react" %%% "extra" % scalaJSReactVersion,
  "com.github.japgolly.scalacss" %%% "core" % scalaCssVersion,
  "com.github.japgolly.scalacss" %%% "ext-react" % scalaCssVersion)


// React itself
//   (react-with-addons.js can be react.js, react.min.js, react-with-addons.min.js)
//DOM, which doesn't exist by default in the Rhino runner. To make the DOM available in Rhino
jsDependencies ++= Seq(
  "org.webjars.npm" % "react"     % reactJSVersion / "react-with-addons.js" commonJSName "React"    minified "react-with-addons.min.js",
  "org.webjars.npm" % "react-dom" % reactJSVersion / "react-dom.js"         commonJSName "ReactDOM" minified "react-dom.min.js" dependsOn "react-with-addons.js"
)


// creates single js resource file for easy integration in html page
skip in packageJSDependencies := false



// copy  javascript files to js folder,that are generated using fastOptJS/fullOptJS

crossTarget in (Compile, fullOptJS) := file("js")

crossTarget in (Compile, fastOptJS) := file("js")

crossTarget in (Compile, packageJSDependencies) := file("js")

crossTarget in (Compile, packageScalaJSLauncher) := file("js")

crossTarget in (Compile, packageMinifiedJSDependencies) := file("js")

artifactPath in (Compile, fastOptJS) := ((crossTarget in (Compile, fastOptJS)).value /
  ((moduleName in fastOptJS).value + "-opt.js"))



scalacOptions += "-feature"

