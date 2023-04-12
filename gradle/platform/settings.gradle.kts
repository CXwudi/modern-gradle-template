dependencyResolutionManagement {
  versionCatalogs {
    create("libs") {
      from(files("../libs.versions.toml"))
    }
  }
}

rootDir.listFiles { file -> file.isDirectory && file.name.endsWith("-version-constraints") }?.forEach {
  include(it.name)
}
