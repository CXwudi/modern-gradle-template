plugins {
  id("my.kotlin-spring-app")
  id("my.app-mixin") // demonstrating using the app-mixin plugin to generate convenience run scripts
}

dependencies {
  implementation(project(":lib"))
}

application {
  // must set the main class when using application plugin
  mainClass.set("poc.cx.glp.springapp.MainAppKt")
}
