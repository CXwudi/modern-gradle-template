import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
  // if you don't want to do set kotlin.pluginLoadedInMultipleProjects.ignore=true in gradle.properties file,
  // then do https://youtrack.jetbrains.com/issue/KT-46200/False-positive-for-The-Kotlin-Gradle-plugin-was-loaded-multiple-times-when-applied-kotlin-and-jvm-plugins-in-different-modules#focus=Comments-27-4850274.0-0
  alias(libs.plugins.kotlinJvm) apply false
  // }
  // if you rely on renovatebot to update your dependencies, then you don't need these plugins
  // and u can delete everything below here
  alias(libs.plugins.benManesVersions)
  alias(libs.plugins.versionCatalogUpdate)
}

fun isNonStable(version: String): Boolean {
  val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.uppercase().contains(it) }
  val regex = "^[0-9,.v-]+(-r)?$".toRegex()
  val isStable = stableKeyword || regex.matches(version)
  return isStable.not()
}

tasks.withType<DependencyUpdatesTask> {
  rejectVersionIf {
    isNonStable(candidate.version)
  }
  gradleReleaseChannel = "current"
}

versionCatalogUpdate {
  sortByKey.set(false)
  keep {
    // keep versions without any library or plugin reference
    keepUnusedVersions.set(true)
    // keep all libraries that aren't used in the project
    keepUnusedLibraries.set(true)
    // keep all plugins that aren't used in the project
    keepUnusedPlugins.set(true)
  }
}
