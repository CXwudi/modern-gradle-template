plugins {
  id("my-kotlin-jvm-base")
  id("my-java-spring-base")
  kotlin("plugin.spring")
}

dependencies {
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude("org.mockito", "mockito-core")
  }
  testImplementation("io.kotest.extensions:kotest-extensions-spring")
  testImplementation("com.ninja-squad:springmockk")
}
