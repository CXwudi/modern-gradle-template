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

// the root of all plugins, configure the jvm
include("root")

// the core mixins, used by the conventions mentioned below
// the main build should try to avoid applying these mixins directly but prefer conventions first
include("mixin:app")
include("mixin:lib")
include("mixin:junit5")
include("mixin:lombok")
include("mixin:kotlin-jvm")
include("mixin:kotest-jvm")
include("mixin:spring-boot")
include("mixin:spring-boot-app")
include("mixin:spring-boot-kotlin")

// the optional mixins, main builds can optionally apply these plugins
include("mixin:spring-boot-appfix")
include("mixin:spring-boot-mockk")

// the conventions, main builds should depend on these first
include("convention:java-app")
include("convention:java-lib")
include("convention:kotlin-app")
include("convention:kotlin-lib")
include("convention:spring-app")
include("convention:spring-lib")
include("convention:kotlin-spring-app")
include("convention:kotlin-spring-lib")
