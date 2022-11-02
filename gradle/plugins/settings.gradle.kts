dependencyResolutionManagement {
  repositories {
    gradlePluginPortal()
  }

  includeBuild("../platform")

  // currently unused, just added for demo purposes
  versionCatalogs {
    create("libs") {
      from(files("../libs.versions.toml"))
    }
  }
}

include("java-plugins")
include("kotlin-jvm-plugins")
include("spring-plugins")
