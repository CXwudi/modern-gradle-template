dependencyResolutionManagement {
  repositories {
    gradlePluginPortal()
    mavenCentral()
  }

  versionCatalogs {
    create("libs") {
      from(files("../libs.versions.toml"))
    }
  }
}

include("java-plugins")
include("kotlin-jvm-plugins")
include("spring-plugins")
