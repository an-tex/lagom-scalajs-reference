pipelineStages in Assets := Seq(scalaJSPipeline)
pipelineStages := Seq(digest, gzip)
compile in Compile := ((compile in Compile) dependsOn scalaJSPipeline).value
