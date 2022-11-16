import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import nl.littlerobots.vcu.plugin.versionCatalogUpdate

/**
 * This convention plugin can and only be applied to the root build.gradle.kts
 */
plugins {
  id("com.github.ben-manes.versions")
  id("nl.littlerobots.version-catalog-update")
}

tasks.named<DependencyUpdatesTask>("dependencyUpdates") {
  gradleReleaseChannel = "current" // don't use the default "release-candidate"
  checkConstraints = true // check version constraints
  revision = "release" // don't use the default "milestone"
  // maven can not distinguish release and milestone, so we have to reject by keywords
  rejectVersionIf {
    listOf("alpha", "beta", "rc", "cr", "m", "eap", "pr").any { qualifier ->
      candidate.version.contains(qualifier, ignoreCase = true)
    }
  }
  outputFormatter = "$outputFormatter,html"
}

versionCatalogUpdate {
  sortByKey.set(false)
  keep { // don't let the plugin delete anything
    keepUnusedLibraries.set(true)
    keepUnusedPlugins.set(true)
    keepUnusedVersions.set(true)
  }
}
