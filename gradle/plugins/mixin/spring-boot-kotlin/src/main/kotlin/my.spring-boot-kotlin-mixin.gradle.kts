plugins {
  id("my.jvm-root")
  kotlin("plugin.spring")
}

dependencies {
  implementation("com.github.CXwudi:kotlin-jvm-inline-logging")
  testImplementation("io.kotest.extensions:kotest-extensions-spring")
  testImplementation("org.mockito.kotlin:mockito-kotlin")
}
