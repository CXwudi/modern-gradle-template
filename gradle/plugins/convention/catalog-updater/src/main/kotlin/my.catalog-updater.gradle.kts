import nl.littlerobots.vcu.plugin.versionCatalogUpdate

/**
 * This convention plugin can and only be applied to the root build.gradle.kts
 */
plugins {
  id("com.github.ben-manes.versions")
  id("nl.littlerobots.version-catalog-update")
}

tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
  rejectVersionIf {
    listOf("alpha", "beta", "rc", "cr", "m", "eap", "pr").any { qualifier ->
      candidate.version.contains(qualifier, ignoreCase = true)
    }
  }
}

versionCatalogUpdate {
  sortByKey.set(false)
  keep { // don't let the plugin delete anything
    keepUnusedLibraries.set(true)
    keepUnusedPlugins.set(true)
    keepUnusedVersions.set(true)
  }
}
