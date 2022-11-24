// this platform is shared by the gradle/plugins build
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

  // add your api() here to manage dependencies not defined in bom or gradle platform
  constraints {
    // plugins dependencies, be used in gradle/plugins build.gradle.kts
    api(libs.plugin.kotlin)
    api(libs.plugin.kotlin.allopen)
    api(libs.plugin.spring.boot)
    api(libs.plugin.spring.dependency.management)
    api(libs.plugin.freefair.lombok)
  }
}
