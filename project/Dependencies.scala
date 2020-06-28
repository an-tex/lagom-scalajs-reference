import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import sbt._

object Dependencies {
  val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.7" % "provided"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.0" % Test
  val chimney = Def.setting("io.scalaland" %%% "chimney" % "0.5.2")

  val lagomJsscalaDslApi = Def.setting("com.github.mliarakos.lagomjs" %%% "lagomjs-scaladsl-api" % "0.4.0-1.6.2")

  val overrides = akka.overrides

  object akka {
    val version = "2.6.5"
    val httpVersion = "10.1.11"

    val actor = "com.typesafe.akka" %% "akka-actor" % version
    val stream = "com.typesafe.akka" %% "akka-stream" % version
    val http = "com.typesafe.akka" %% "akka-http" % httpVersion
    val typed = "com.typesafe.akka" %% "akka-actor-typed" % version
    val persistenceTyped = "com.typesafe.akka" %% "akka-persistence-typed" % version
    val streamTyped = "com.typesafe.akka" %% "akka-stream-typed" % version
    val testkit = "com.typesafe.akka" %% "akka-testkit" % version
    val testkitTyped = "com.typesafe.akka" %% "akka-actor-testkit-typed" % version
    val streamTestkit = "com.typesafe.akka" %% "akka-stream-testkit" % version

    val overrides = Seq(
      "akka-http",
      "akka-http-core",
      "akka-http-spray-json",
      "akka-parsing",
      "akka-http-xml"
    ).map("com.typesafe.akka" %% _ % httpVersion) ++
      Seq(
        "akka-actor",
        "akka-actor-testkit-typed",
        "akka-actor-typed",
        "akka-cluster",
        "akka-cluster-sharding",
        "akka-cluster-sharding-typed",
        "akka-cluster-tools",
        "akka-cluster-typed",
        "akka-coordination",
        "akka-discovery",
        "akka-distributed-data",
        "akka-persistence",
        "akka-persistence-query",
        "akka-persistence-typed",
        "akka-protobuf-v3",
        "akka-remote",
        "akka-slf4j",
        "akka-stream"
      ).map("com.typesafe.akka" %% _ % version)

    object management {
      val version = "1.0.7"

      val core = "com.lightbend.akka.management" %% "akka-management" % version
      val discoveryKubernetesApi = "com.lightbend.akka.discovery" %% "akka-discovery-kubernetes-api" % version
      val clusterBootstrap = "com.lightbend.akka.management" %% "akka-management-cluster-bootstrap" % version
      val clusterHttp = "com.lightbend.akka.management" %% "akka-management-cluster-http" % version
    }
  }

  object circe {
    val version = "0.13.0"

    val core = Def.setting("io.circe" %%% "circe-core" % version)
    val generic = Def.setting("io.circe" %%% "circe-generic" % version)
    val genericExtras = Def.setting("io.circe" %%% "circe-generic-extras" % version)
    val parser = Def.setting("io.circe" %%% "circe-parser" % version)
  }
}