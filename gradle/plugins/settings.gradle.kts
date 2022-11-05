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

// current grouping strategy: each plugin is a separate submodule to maximize parallelism
include("root")
include("mixin:app")
include("mixin:lib")
include("mixin:junit5")
include("mixin:lombok")
// include("java-plugins")
// include("kotlin-jvm-plugins")
// include("spring-plugins:java")
// include("spring-plugins:kotlin-jvm")
