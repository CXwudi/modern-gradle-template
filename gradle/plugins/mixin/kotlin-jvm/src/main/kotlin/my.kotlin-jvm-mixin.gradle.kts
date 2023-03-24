import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

plugins {
  id("my.jvm-root")
  kotlin("jvm")
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(kotlin("reflect"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm")
}

tasks.withType<KotlinCompilationTask<KotlinJvmCompilerOptions>>().configureEach {
  compilerOptions {
    javaParameters.set(true) // see the same reason in jvm-root mixin
    // kotlin will use a java tool chain version,
    // see https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
  }
}
