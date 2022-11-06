plugins {
  id("my.jvm-root")
  kotlin("plugin.spring")
}

configurations {
  all {
    exclude(group = "org.mockito")
  }
}

dependencies {
  implementation("com.github.CXwudi:kotlin-jvm-inline-logging")
  testImplementation("io.kotest.extensions:kotest-extensions-spring")
  testImplementation("io.mockk:mockk")
  testImplementation("com.ninja-squad:springmockk")
}
