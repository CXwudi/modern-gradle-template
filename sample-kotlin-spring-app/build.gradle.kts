plugins {
  id("my.kotlin-spring-app")
  id("my.app-mixin") // demonstrating using the app-mixin plugin to generate convenience run scripts
  id("my.spring-boot-appfix-mixin") // demonstrating using the spring-boot-appfix-mixin plugin to fix the spring boot start script
//  id("my.spring-boot-mockk-mixin") // u can add other mixins if you want
}

dependencies {
  implementation(project(":sample-java-lib"))
}

application {
  // must set the main class when using application plugin
  mainClass.set("poc.cx.glp.springapp.MainAppKt")
}
