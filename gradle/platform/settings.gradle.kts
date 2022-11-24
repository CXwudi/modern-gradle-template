dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      from(files("../libs.versions.toml"))
    }
  }
}

include("dev-version-constraints")
include("plugin-version-constraints")
