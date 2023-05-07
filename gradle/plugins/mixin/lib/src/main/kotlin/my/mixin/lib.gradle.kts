package my.mixin

plugins {
  id("my.root.jvm")
  `java-library`
}

java {
  withSourcesJar()
}

/**
 * Similar to [versionConstraints] in jvm.gradle.kts but for api() and compileOnlyApi()
 *
 * Warning:
 * By using this configuration to declare a platform,
 * the consumer of this library will also have the platform.
 * So use it in caution.
 */
val apiVersionConstraints: Configuration = configurations.create("apiVersionConstraints") {
  // see the table 1 in https://docs.gradle.org/current/userguide/declaring_dependencies.html#sec:resolvable-consumable-configs
  isCanBeConsumed = false
  isCanBeResolved = false
  description = "A configuration to declare platform (version constraints) in every other consumable configurations"
}
configurations {
  versionConstraints.get().extendsFrom(apiVersionConstraints)
  listOf("api", "compileOnlyApi").forEach {
    getByName(it).extendsFrom(apiVersionConstraints)
  }
}

dependencies {
  // it is safe to use our own platform here, since any consumer is already using our own platform
  apiVersionConstraints(platform("poc.cx.glp:dev-version-constraints"))
}
