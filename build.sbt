import Common._
import Dependencies._
import sbtcrossproject.CrossPlugin.autoImport.{CrossType, crossProject}

import scala.util.Random

lazy val reference = (project in file("."))
  .aggregate(
    common,
    circeLagom.jvm,
    circeLagom.js,
    service1Api.jvm,
    service1Api.js,
    service1Server,
    service1UiClient,
    service1UiServer,
    service2Api,
    service2Server
  )

lazy val common = project in file("common")

lazy val circeLagom =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .in(file("circe-lagom"))
    .jvmSettings(lagomApi)
    .jsSettings(lagomApiJs)
    .settings(libraryDependencies ++= Seq(
      circe.core.value,
      circe.genericExtras.value,
      circe.parser.value
    ))

lazy val service1Api =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Pure)
    .in(file("service1/api"))
    .jvmSettings(lagomApi)
    .jsSettings(lagomApiJs)
    .dependsOn(circeLagom)

lazy val service1Server = (project in file("service1/server"))
  .enablePlugins(LagomScala)
  .settings(lagom)
  .dependsOn(common, service1Api.jvm, service2Api)

lazy val service2Api = (project in file("service2/api"))
  .settings(lagomApi)
  .dependsOn(circeLagom.jvm)

lazy val service2Server = (project in file("service2/server"))
  .enablePlugins(LagomScala)
  .settings(lagom)
  .dependsOn(common, service2Api)

lazy val service1UiServer = (project in file("service1/ui/server"))
  .settings(scalaJSProjects := Seq(service1UiClient))
  .settings(Common.play)
  .enablePlugins(LagomPlayScala, WebScalaJSBundlerPlugin)
  .dependsOn(common)

lazy val service1UiClient = (project in file("service1/ui/client"))
  .enablePlugins(ScalaJSBundlerPlugin, ScalablyTypedConverterPlugin)
  .dependsOn(common, service1Api.js)

ThisBuild / organization := "ag.rob"
ThisBuild / scalaVersion := "2.13.3"

ThisBuild / sources in doc in Compile := List()
ThisBuild / publishArtifact in(Compile, packageDoc) := false
ThisBuild / lagomKafkaEnabled := false
ThisBuild / lagomCassandraEnabled := false
ThisBuild / lagomServiceLocatorPort := Random.nextInt(10000) + 50000
ThisBuild / lagomServiceGatewayPort := Random.nextInt(10000) + 50000
ThisBuild / skip in publish := true
ThisBuild / dynverSeparator := "-"
ThisBuild / dependencyOverrides ++= Dependencies.overrides
