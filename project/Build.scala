import sbt._
import Keys._
import org.scalajs.sbtplugin.ScalaJSPlugin
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

object ScalaJSReactMdl {
  object Versions {
    val scala = "2.11.8"
    val scalatest = "3.0.1"
    val htmlWebpackPlugin = "~2.26.0"
    val copyWebpackPlugin = "~4.0.1"
    val htmlLoader = "~0.4.3"
    val react = "~15.4.2"
    val scalaJsReact = "0.1.0-SNAPSHOT"
    val reactMdl = "^1.7.2"
    val cssLoader = "^0.25.0"
    val styleLoader = "^0.13.1"
    val reactMdlExtra = "^1.4.3"

    val scalaJsRedux = "0.3.0-SNAPSHOT"
    val scalaJsReactReduxForm = "0.1.0-SNAPSHOT"
    val reduxLogger = "~2.7.4"
  }

  object Dependencies {
    lazy val scalaJsReact = "com.github.eldis" %%%! "scalajs-react" % Versions.scalaJsReact

    lazy val scalatest = "org.scalatest" %%%! "scalatest" % Versions.scalatest % "test"

    lazy val jsReact = Seq(
      "react" -> Versions.react,
      "react-dom" -> Versions.react,
      "react-mdl" -> Versions.reactMdl
    )

    lazy val scalaJsReactReduxForm = Seq(
      "com.github.eldis" %%%! "scalajs-redux-react-eldis"% Versions.scalaJsRedux,
      "com.github.eldis" %%%! "scalajs-react-redux-form" % Versions.scalaJsReactReduxForm
    )

    lazy val reduxLogger = Seq("redux-logger" -> Versions.reduxLogger)
  }

  object Settings {
    type PC = Project => Project

    def commonProject: PC =
      _.settings(
        scalaVersion := Versions.scala,
        organization := "com.github.eldis"
      )

    def scalajsProject: PC =
      _.configure(commonProject)
        .enablePlugins(ScalaJSPlugin)
        .settings(
          scalaJSModuleKind := ModuleKind.CommonJSModule,
          requiresDOM in Test := true
        )

    def jsBundler: PC =
      _.enablePlugins(ScalaJSBundlerPlugin)
        .settings(
          enableReloadWorkflow := false,
          libraryDependencies += Dependencies.scalatest
        )

    def react: PC =
      _.settings(
        libraryDependencies ++= Seq(Dependencies.scalaJsReact),
        npmDevDependencies in Compile ++= Dependencies.jsReact,
        npmDependencies in Compile ++= Dependencies.jsReact
      )

    def scalaJsReactReduxForm: PC =
      _.settings(
        libraryDependencies ++= Dependencies.scalaJsReactReduxForm,
        npmDependencies in Compile ++= Dependencies.reduxLogger
      )


    def exampleProject(prjName: String): PC = { p: Project =>
      p.in(file("examples") / prjName)
        .configure(scalajsProject, jsBundler, react)
        .settings(
          name := prjName,

          npmDevDependencies in Compile ++= Seq(
            "html-webpack-plugin" -> Versions.htmlWebpackPlugin,
            "copy-webpack-plugin" -> Versions.copyWebpackPlugin,
            "html-loader" -> Versions.htmlLoader,
            "react-mdl-extra" -> Versions.reactMdlExtra,
            "style-loader" -> Versions.styleLoader,
            "css-loader" -> Versions.cssLoader
          ),

          webpackConfigFile in fastOptJS := Some(baseDirectory.value / "config" / "webpack.config.js"),
          webpackConfigFile in fullOptJS := Some(baseDirectory.value / "config" / "webpack.config.js")
        )
    }

    def publish: PC =
      _.settings(
        publishMavenStyle := true,
        publishTo := {
          val nexus = "https://oss.sonatype.org/"
          if (isSnapshot.value)
            Some("snapshots" at nexus + "content/repositories/snapshots")
          else
            Some("releases"  at nexus + "service/local/staging/deploy/maven2")
        }
      )
  }

  object Projects {
    lazy val scalaJsReactMdl = project.in(file("."))
      .configure(
        Settings.scalajsProject, Settings.jsBundler, Settings.publish, Settings.react
      )
      .settings(
        name := "scalajs-react-mdl"
      )

    lazy val ex1 = project.configure(
      Settings.exampleProject("ex1"), Settings.scalaJsReactReduxForm
    ).dependsOn(scalaJsReactMdl)
  }
}