import Dependencies._
import com.lightbend.lagom.sbt.LagomImport._
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport._
import com.typesafe.sbt.packager.universal.UniversalPlugin.autoImport._
import sbt.Keys._

object Common {
  private[this] val deployable = Seq(
    dockerExposedPorts := Seq(9000),
    dockerUpdateLatest := true,
    dockerRepository := sys.env.get("CI_REGISTRY_IMAGE"),
    javaOptions in Universal ++= Seq(
      "-Dpidfile.path=/dev/null"
    )
  )

  val lagom = deployable ++ Seq(
    libraryDependencies ++= Seq(
      lagomScaladslTestKit,
      macwire,
      scalaTest
    )) ++ lagomForkedTestSettings

  val lagomApi = Seq(
    libraryDependencies ++= Seq(lagomScaladslApi)
  )

  val lagomApiJs = Seq(
    libraryDependencies ++= Seq(lagomJs.scalaApi.value)
  )

  val play = deployable
}
