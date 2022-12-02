/**
 * require kotlin-mixin and spring-boot-mixin
 */
plugins {
  id("my.jvm-root")
  kotlin("plugin.spring")
}

dependencies {
  implementation("com.github.CXwudi:kotlin-jvm-inline-logging")
  testImplementation("io.kotest.extensions:kotest-extensions-spring")
  testImplementation("org.mockito.kotlin:mockito-kotlin")
  // due to https://github.com/Ninja-Squad/springmockk#limitations, mockk and springmockk are not added by default here,
  // use my.spring-boot-mockk-mixin to add mockk instead
}
