pluginManagement {
  repositories {
    gradlePluginPortal()
    // google()
  }
  includeBuild("gradle/plugins") // use this to include our own convention plugins
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
  // unfortunately, we don't know how to use version catalog in root settings that are.gradle
  id("com.gradle.enterprise") version "3.12.5"
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
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
