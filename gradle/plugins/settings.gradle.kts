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

// current grouping strategy: each script plugin is a separate submodule to maximize parallelism
// the root of all jvm
include("root")
// the mixins, no main build should directly depend on these
include("mixin:app")
include("mixin:lib")
include("mixin:junit5")
include("mixin:lombok")
include("mixin:kotlin-jvm")
include("mixin:kotest-jvm")
// the conventions, main builds should depend on these
include("convention:java-app")
include("convention:java-lib")
include("convention:kotlin-app")
include("convention:kotlin-lib")
// include("java-plugins")
// include("kotlin-jvm-plugins")
// include("spring-plugins:java")
// include("spring-plugins:kotlin-jvm")
