plugins {
  id("application")
  id("my-java-base")
}

// tasks.register<JarCount>("countJars") {
//  group = "My Task Group"
//  description = "Count the number of jars in the classpath"
//
//  allJars.from(tasks.jar)
//  allJars.from(configurations.runtimeClasspath)
//
//  countFile.set(layout.buildDirectory.file("gen/count.txt"))
// }
//
// tasks.register<Zip>("bundle") {
//
//  group = "My Task Group"
//  description = "My Task Description"
//
//  from(tasks.jar) // we could put build/libs/*.jar, but we should use gradle task output
//  from(configurations.runtimeClasspath)
//
//  destinationDirectory.set(layout.buildDirectory.dir("distribution"))
// }
//
// tasks.build {
//  dependsOn(tasks.named("bundle")) // wiring my task so that the build lifecycle task always runs my task
// }
//
// tasks.register("myLifeCycle") { // no type = DefaultTask
//
//  description = "My Life Cycle Task That build + countJars"
//
//  dependsOn(tasks.build)
//  dependsOn(tasks.named("countJars"))
// }
