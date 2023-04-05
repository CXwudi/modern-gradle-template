pluginManagement {
  repositories {
    gradlePluginPortal()
    // google()
  }
  includeBuild("gradle/plugins") // use this to include our own convention plugins
  includeBuild("gradle/settings") // use this to include our own convention plugins for settings.gradle.kts
}

dependencyResolutionManagement {
  repositories {
    mavenCentral()
    // google()
    maven("https://jitpack.io")
  }

  includeBuild("gradle/platform") // use this to include our own gradle platform to centralize version management
  // gradle/libs.versions.toml is automatically imported if exists
}

plugins {
  // my setting plugin that simply has some other setting plugins where versions are managed in version catalogs
  id("my.root-settings-plugins")
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}

rootProject.name = "gradle-learn-project"

rootDir.listFiles { file -> file.isDirectory && !file.isHidden && file.name.startsWith("sample-") }?.forEach {
  include(it.name)
}
