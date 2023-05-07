package my.mixin

plugins {
  id("my.root.jvm")
  application
}

application {
  // we don't want the run scripts in bin folder, but at the root folder
  executableDir = ""
}

tasks.named<org.gradle.jvm.application.tasks.CreateStartScripts>("startScripts") {
  // use wildcard to include all jars in lib folder,
  // instead of default behavior of listing each jar name and version explicitly,
  // so that this enables hot swapping of jars in lib folder
  classpath = files("lib/*")
}
