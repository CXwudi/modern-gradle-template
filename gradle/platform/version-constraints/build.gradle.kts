// this platform is shared by both the main build and the gradle/plugins build
plugins {
  id("java-platform")
}

group = "poc.cx.glp"

javaPlatform {
  allowDependencies()
}

// add bom, gradle platforms, and dependencies to the shared libs.version.toml first
// so that version-catalog-updater can update them,
// then add them here using the version catalog
// also, this should be the only place where you use the version catalog to add dependencies
dependencies {
  // add your maven bom or gradle platform here

  // benefit from spring boot's version management for non-spring projects
  // see https://docs.spring.io/spring-boot/docs/current/reference/html/dependency-versions.html to check what lib is included
  api(platform(libs.bom.spring.boot.dependencies))
  // api(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.6.4")) // enable if spring screws up coroutines
  api(platform(libs.bom.kotest))
  constraints {
    // add your api() here to manage dependencies not defined in bom or gradle platform
    // plugins dependencies, be used in gradle/plugins build.gradle.kts
    api(libs.plugin.kotlin)
    api(libs.plugin.kotlin.allopen)
    api(libs.plugin.spring.boot)
    api(libs.plugin.spring.dependency.management)
    api(libs.plugin.freefair.lombok)

    // main build dependencies, be used in the actual app and lib build.gradle.kts
    api(libs.dep.kotlin.jvm.inline.logging)
    api(libs.dep.kotest.extensions.spring)
    api(libs.dep.mockito.kotlin)
    api(libs.dep.mockk)
    api(libs.dep.spring.mockk)
  }
}
