import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
  }
}
