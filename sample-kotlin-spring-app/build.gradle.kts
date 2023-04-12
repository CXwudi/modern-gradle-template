import my.mixin.springboot.MySpringBootLoggingFramework

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
  id("my.kotlin-spring-app")
  id("my.app-mixin") // demonstrating using the app-mixin plugin to generate convenience run scripts
//  id("my.spring-boot-mockk-mixin") // u can add other mixins if you want
  alias(libs.plugins.graalvm.native.image) // demonstrating using plugin directly from version catalog
}

dependencies {
  implementation(project(":sample-java-lib"))
  implementation(project(":sample-kotlin-spring-lib"))
}

application {
  // must set the main class when using application plugin
  mainClass.set("poc.cx.glp.springapp.MainAppKt")
}

mySpringBootApp {
  loggingFramework.set(MySpringBootLoggingFramework.LOGBACK)
}

// mySpringBootKotlinMock {
//  mockFramework.set(MockFramework.MOCKK)
// }
