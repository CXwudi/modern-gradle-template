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

// new way to configure kotlin compiler options,
// see https://kotlinlang.org/docs/gradle-compiler-options.html#how-to-define-options
listOf("compileKotlin", "compileTestKotlin").forEach {
  tasks.named<KotlinCompilationTask<KotlinJvmCompilerOptions>>(it) {
    compilerOptions {
      javaParameters.set(true) // see the same reason in jvm-root mixin
      // kotlin will use a java tool chain version,
      // see https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
    }
  }
}
