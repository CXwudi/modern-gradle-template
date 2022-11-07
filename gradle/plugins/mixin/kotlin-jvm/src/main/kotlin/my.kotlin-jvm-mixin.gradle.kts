import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("my.jvm-root")
  kotlin("jvm")
}

dependencies {
  implementation(kotlin("stdlib-jdk8"))
  implementation(kotlin("reflect"))
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions {
    javaParameters = true // see the same reason in jvm-root mixin
  }
}
