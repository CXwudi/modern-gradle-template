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
    // jvmTarget is auto-resolved when using java-toolchain,
    // but intellij is not happy, so adding it explicitly
    jvmTarget = java.toolchain.languageVersion.get().asInt().toString()
  }
}
