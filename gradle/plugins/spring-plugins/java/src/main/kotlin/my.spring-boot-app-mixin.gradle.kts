plugins {
  id("my.spring-boot-mixin")
  id("org.springframework.boot")
  // optional, can be used to distribute build scripts for click and run.
  // but need to set applications.mainClass explicitly in build.gradle.kts
  // it's better to app this plugin at the main spring app build who really needs it.
  // id("my.app-mixin")
}
