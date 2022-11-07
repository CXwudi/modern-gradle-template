plugins {
  id("my.kotlin-spring-app")
  id("my.app-mixin") // demonstrating using the app-mixin plugin to generate convenience run scripts
  // adding this can force the spring boot start script to be generated in root directory of the distribution
  // instead of bin/ directory
  // but this is kind of useless because if you need the start script,
  // why not just use gradle's application plugin?
//  id("my.spring-boot-appfix-mixin")
//  id("my.spring-boot-mockk-mixin") // u can add other mixins if you want
}

dependencies {
  implementation(project(":sample-java-lib"))
}

application {
  // must set the main class when using application plugin
  mainClass.set("poc.cx.glp.springapp.MainAppKt")
}
