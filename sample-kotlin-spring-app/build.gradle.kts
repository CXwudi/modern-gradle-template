@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id("my.kotlin-spring-app")
  id("my.app-mixin") // demonstrating using the app-mixin plugin to generate convenience run scripts
//  id("my.spring-boot-mockk-mixin") // u can add other mixins if you want
  alias(libs.plugins.graalvm.native.image) // demonstrating using plugin directly from version catalog
}

dependencies {
  implementation(project(":sample-java-lib"))
}

application {
  // must set the main class when using application plugin
  mainClass.set("poc.cx.glp.springapp.MainAppKt")
}

// springBootMockk { // "my.spring-boot-mockk-mixin" can exclude mockito if u want
//  excludeMockito.set(true)
// }
