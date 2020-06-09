libraryDependencies ++= Seq(
  "com.github.japgolly.scalajs-react" %%% "core" % "1.7.0",
  "com.github.japgolly.scalajs-react" %%% "extra" % "1.7.0",
  "com.github.japgolly.scalacss" %%% "core" % "0.6.1",
  "com.github.japgolly.scalacss" %%% "ext-react" % "0.6.1",
  "org.scala-js" %%% "scalajs-dom" % "1.0.0",
  "io.suzaku" %%% "diode" % "1.1.9",
  "io.suzaku" %%% "diode-react" % "1.1.9.170",
  "com.github.mliarakos.lagomjs" %%% "lagomjs-scaladsl-client" % "0.4.0-1.6.2",
  Dependencies.chimney.value
)

Compile / npmDependencies ++= Seq(
  "react" -> "16.13.1",
  "react-dom" -> "16.13.1",
  "@types/react" -> "16.9.35",
  "@types/react-dom" -> "16.9.8",
  "antd" -> "4.2.5",
  "css-loader" -> "3.5.3",
  "style-loader" -> "1.2.1",
  "less" -> "3.11.1",
  "less-loader" -> "6.1.0",
  "@fortawesome/fontawesome-svg-core" -> "1.2.28",
  "@fortawesome/react-fontawesome" -> "0.1.8"
) ++ Seq(
  "@fortawesome/free-brands-svg-icons",
  "@fortawesome/pro-light-svg-icons",
  "@fortawesome/pro-solid-svg-icons",
  "@fortawesome/pro-regular-svg-icons",
  "@fortawesome/pro-duotone-svg-icons"
).map(_ -> "5.13.0")

stFlavour := Flavour.Japgolly
useYarn := true
stIgnore ++= List(
  "csstype",
)

version in webpack := "4.43.0"
version in startWebpackDevServer := "3.11.0"
webpackBundlingMode := BundlingMode.LibraryOnly("moinmusic")
webpackConfigFile := Some(baseDirectory.value / "webpack.config.js")
scalaJSUseMainModuleInitializer := true

