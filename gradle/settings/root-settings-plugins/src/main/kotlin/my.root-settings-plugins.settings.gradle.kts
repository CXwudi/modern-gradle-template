/**
 * Settings plugin used by the root settings.gradle.kts that simply just apply some other setting plugins,
 * where versions are managed by the grade/platform through version catalogs.
 */
plugins {
  id("com.gradle.enterprise")
  id("org.gradle.toolchains.foojay-resolver-convention")
}
