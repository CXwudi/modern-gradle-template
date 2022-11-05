plugins {
  id("my.kotlin-jvm-mixin")
  id("my.kotest-jvm-mixin")
  kotlin("plugin.spring")
}

dependencies {
  implementation("com.github.CXwudi:kotlin-jvm-inline-logging")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.kotest.extensions:kotest-extensions-spring")
}
