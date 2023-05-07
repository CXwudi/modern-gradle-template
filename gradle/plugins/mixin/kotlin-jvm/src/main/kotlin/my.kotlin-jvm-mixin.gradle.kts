plugins {
  id("my.jvm-root")
  kotlin("jvm")
}

dependencies {
  implementation(kotlin("stdlib"))
  implementation(kotlin("reflect"))
  implementation(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm")
}

kotlin {
  target {
    compilations.all {
      kotlinOptions {
        javaParameters = true // see the same reason in jvm-root mixin
        // kotlin will use a java tool chain version,
        // see https://kotlinlang.org/docs/gradle-configure-project.html#gradle-java-toolchains-support
      }
    }
  }
}
