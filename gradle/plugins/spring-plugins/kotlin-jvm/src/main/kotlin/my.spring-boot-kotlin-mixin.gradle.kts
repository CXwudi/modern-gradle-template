plugins {
  id("my.spring-boot-mixin")
  id("my.kotlin-jvm-mixin")
  id("my.kotest-jvm-mixin")
  kotlin("plugin.spring")
}

dependencies {
  implementation("com.github.CXwudi:kotlin-jvm-inline-logging")
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude("org.mockito", "mockito-core")
  }
  testImplementation("io.kotest.extensions:kotest-extensions-spring")
  testImplementation("com.ninja-squad:springmockk")
}
