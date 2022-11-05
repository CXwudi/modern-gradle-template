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

// current grouping strategy: group by dependencies used by a module. 
// e.g. kotlin-jvm-plugins introduced kotlin plugin dependencies
include("root-plugins")
include("java-plugins")
include("kotlin-jvm-plugins")
include("spring-plugins:java")
include("spring-plugins:kotlin-jvm")
