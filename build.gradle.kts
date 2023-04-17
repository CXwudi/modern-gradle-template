// this root build.gradle.kts is only used by the workaround below
plugins {
  // if you don't want to do set kotlin.pluginLoadedInMultipleProjects.ignore=true in gradle.properties file,
  // then do https://youtrack.jetbrains.com/issue/KT-46200/False-positive-for-The-Kotlin-Gradle-plugin-was-loaded-multiple-times-when-applied-kotlin-and-jvm-plugins-in-different-modules#focus=Comments-27-4850274.0-0
  alias(libs.plugins.kotlin.jvm) apply false
}
