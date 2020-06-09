addSbtPlugin("com.lightbend.lagom" % "lagom-sbt-plugin" % "1.6.2")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.5.0")
addSbtPlugin("com.dwijnand" % "sbt-dynver" % "4.0.0")

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.0.0")

resolvers += Resolver.bintrayRepo("oyvindberg", "converter")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.1.0")
addSbtPlugin("ch.epfl.scala" % "sbt-web-scalajs-bundler" % "0.17.0")
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta15")
addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.11")

addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.4")

