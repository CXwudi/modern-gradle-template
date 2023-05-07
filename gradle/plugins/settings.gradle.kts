dependencyResolutionManagement {
  repositories {
    gradlePluginPortal()
  }
  // currently unused, just added for demo purposes
//  includeBuild("../platform")

  versionCatalogs {
    create("libs") {
      from(files("../libs.versions.toml"))
    }
  }
}

// current grouping strategy: each script plugin is a separate submodule to maximize parallelism
// first, include the root of all plugins, only configure the jvm
include("root")

val toResolvedDirectories = listOf(
  // then, configure the core mixins and the optional mixins used by the conventions mentioned below
  // the main build should prefer conventions first, then use some optional mixins
  "mixin",
  // last, the conventions, main builds should depend on these first
  "convention",
)

toResolvedDirectories.forEach { dir ->
  rootDir.resolve(dir).listFiles { file -> file.isDirectory && !file.isHidden }?.forEach {
    include("$dir:${it.name}")
  }
}
