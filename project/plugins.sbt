addSbtPlugin("com.lightbend.lagom" % "lagom-sbt-plugin" % "1.6.2")
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.5.0")
addSbtPlugin("com.dwijnand" % "sbt-dynver" % "4.0.0")

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.0.0")

resolvers += Resolver.bintrayRepo("oyvindberg", "converter")

// sjs 0.6x
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.33")
addSbtPlugin("ch.epfl.scala" % "sbt-web-scalajs-bundler-sjs06" % "0.18.0")
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter06" % "1.0.0-beta12")
addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.11-0.6")

// sjs 1.x
//addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.0.1")
//addSbtPlugin("ch.epfl.scala" % "sbt-web-scalajs-bundler" % "0.17.0")
//addSbtPlugin("org.scalablytyped.converter" % "sbt-converter" % "1.0.0-beta12")
//addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.11")

addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.4")

