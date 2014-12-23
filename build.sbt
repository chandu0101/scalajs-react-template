import scala.scalajs.sbtplugin.ScalaJSPlugin.ScalaJSKeys._

name := "scalajs-react-template"

version := "1.0"

scalaVersion := "2.11.4"


scalaJSSettings

persistLauncher := true

persistLauncher in Test := false


libraryDependencies += "com.github.japgolly.scalajs-react" %%% "core" % "0.7.2-SNAPSHOT"

libraryDependencies += "com.github.japgolly.scalajs-react" %%% "extras" % "0.7.2-SNAPSHOT"

resolvers += "bintray/non" at "http://dl.bintray.com/non/maven"

libraryDependencies += "com.lihaoyi" %%% "upickle" % "0.2.5"


// React itself
//   (react-with-addons.js can be react.js, react.min.js, react-with-addons.min.js)
//DOM, which doesn't exist by default in the Rhino runner. To make the DOM available in Rhino
jsDependencies ++=  Seq(
  "org.webjars" % "react" % "0.12.1" / "react-with-addons.js" commonJSName "React",
   scala.scalajs.sbtplugin.RuntimeDOM )


//jsDependencies += ProvidedJS / "react-async.js"


// creates single js resource file for easy integration in html page
skip in packageJSDependencies := false

// uTest settings
utest.jsrunner.Plugin.utestJsSettings


// copy  javascript files to js folder,that are generated using fastOptJS/fullOptJS

crossTarget in (Compile, fullOptJS) := file("js")

crossTarget in (Compile, fastOptJS) := file("js")

crossTarget in (Compile, packageJSDependencies) := file("js")

crossTarget in (Compile, packageScalaJSLauncher) := file("js")

artifactPath in (Compile, fastOptJS) := ((crossTarget in (Compile, fastOptJS)).value /
  ((moduleName in fastOptJS).value + "-opt.js"))

scalacOptions += "-feature"

