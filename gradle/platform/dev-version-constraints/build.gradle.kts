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
  // maven bom or gradle platform should have been added here with api(platform())
  // but since this platform is imported to every other project by being imported at root jvm plugin,
  // we don't want version conflict to happen from multiple api(platform()).

  // add your api() here to manage dependencies not defined in bom or gradle platform
  constraints {
    // maven bom or gradle platform
    api(libs.bom.kotest)
    // here, we prefer spring boot's version management for non-spring projects.
    // you can replace it with something else (like micronaut bom) if you want
    // see https://docs.spring.io/spring-boot/docs/current/reference/html/dependency-versions.html
    // to check what lib is included
    api(libs.bom.spring.boot)
    // api("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.6.4") // enable if spring screws up coroutines

    // main build dependencies, be used in the actual app and lib build.gradle.kts
    api(libs.dep.kotlin.jvm.inline.logging)
    api(libs.dep.kotest.extensions.spring)
    api(libs.dep.mockito.kotlin)
    api(libs.dep.mockk)
    api(libs.dep.spring.mockk)
  }
}
