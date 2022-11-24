// this platform is shared in the main build
plugins {
  id("java-platform")
}

group = "poc.cx.glp"

javaPlatform {
  allowDependencies()
}

// add bom, gradle platforms, and dependencies to the shared libs.version.toml first
// then add them here using the version catalog
dependencies {
  // add your maven bom or gradle platform here

  // benefit from spring boot's version management for non-spring projects
  // see https://docs.spring.io/spring-boot/docs/current/reference/html/dependency-versions.html to check what lib is included
  api(platform(libs.bom.spring.boot.dependencies))
  // api(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.6.4")) // enable if spring screws up coroutines
  api(platform(libs.bom.kotest))
  // add your api() here to manage dependencies not defined in bom or gradle platform
  constraints {
    // main build dependencies, be used in the actual app and lib build.gradle.kts
    api(libs.dep.kotlin.jvm.inline.logging)
    api(libs.dep.kotest.extensions.spring)
    api(libs.dep.mockito.kotlin)
    api(libs.dep.mockk)
    api(libs.dep.spring.mockk)
  }
}
