pluginManagement {
  repositories {
    gradlePluginPortal()
    // google()
  }
  includeBuild("gradle/plugins") // use this to include our own convention plugins
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
    // google()
    maven("https://jitpack.io")
  }

  includeBuild("gradle/platform") // use this to include our own gradle platform to centralize version management
  // the gradle/libs.versions.toml file is included by default, no need to declare it here
}

rootProject.name = "gradle-learn-project"

include("lib")
include("app")
include("spring-app")
