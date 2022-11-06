plugins {
  id("my.kotlin-spring-app")
  id("my.app-mixin") // demonstrating using the app-mixin plugin to generate convenience run scripts
  id("my.spring-boot-mockk-mixin") // u can add other mixin if you want
}

dependencies {
  implementation(project(":sample-java-lib"))
}

application {
  // must set the main class when using application plugin
  mainClass.set("poc.cx.glp.springapp.MainAppKt")
}
