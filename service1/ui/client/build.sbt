libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "1.6.0",
  "com.github.japgolly.scalajs-react" %%% "extra" % "1.6.0",
  "com.github.japgolly.scalacss" %%% "core" % "0.6.0",
  "com.github.japgolly.scalacss" %%% "ext-react" % "0.6.0",
  "org.scala-js" %%% "scalajs-dom" % "1.0.0",
)

val fontAwesomeVersion = "5.13.0"

Compile / npmDependencies ++= Seq(
  "react" -> "16.7.0",
  "react-dom" -> "16.7.0",
  "antd" -> "3.26.16",
  "css-loader" -> "3.5.3",
  "style-loader" -> "1.2.1",
  "less" -> "3.11.1",
  "less-loader" -> "6.1.0",
  "@fortawesome/fontawesome-svg-core" -> "1.2.28",
  "@fortawesome/free-brands-svg-icons" -> fontAwesomeVersion,
  "@fortawesome/pro-light-svg-icons" -> fontAwesomeVersion,
  "@fortawesome/pro-solid-svg-icons" -> fontAwesomeVersion,
  "@fortawesome/pro-regular-svg-icons" -> fontAwesomeVersion,
  "@fortawesome/pro-duotone-svg-icons" -> fontAwesomeVersion,
  "@fortawesome/react-fontawesome" -> "0.1.8"
)

stFlavour := Flavour.Japgolly
useYarn := true

version in webpack := "4.43.0"
version in startWebpackDevServer := "3.11.0"
webpackBundlingMode := BundlingMode.LibraryOnly("moinmusic")
webpackConfigFile := Some(baseDirectory.value / "webpack.config.js")
scalaJSUseMainModuleInitializer := true

//stIgnore ++= List(
//  "csstype",
//  "dayjs"
//)
