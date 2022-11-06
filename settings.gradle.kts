pluginManagement {
  repositories {
    gradlePluginPortal()
    // google()
  }
  includeBuild("build-logic/plugins") // use this to include our own convention plugins
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
    // google()
    maven("https://jitpack.io")
  }

  includeBuild("build-logic/platform") // use this to include our own gradle platform to centralize version management

  versionCatalogs { // currently unused, just added for demo purposes
    create("libs") {
      from(files("build-logic/libs.versions.toml")) // if it is gradle/libs.versions.toml, then no need to add it manually here
    }
  }
}

rootProject.name = "gradle-learn-project"

include("lib")
include("app")
include("spring-app")
