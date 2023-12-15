package my.root
/**
 * The root plugin only defines the java version, dependency version constraints and a new configuration called [versionConstraints].
 */
plugins {
  java
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
  }
}

tasks.withType<JavaCompile>().configureEach {
  options.apply {
    encoding = "UTF-8"
    // should we add `-parameters`?
    // I think we can, https://stackoverflow.com/questions/44067477/drawbacks-of-javac-parameters-flag
    compilerArgs.add("-parameters")
    isFork = true
  }
}

/**
 * A new configuration [versionConstraints] just for dependency version constraints.
 */
val versionConstraints: Configuration = configurations.create("versionConstraints") {
  // see the table 1 in https://docs.gradle.org/current/userguide/declaring_dependencies.html#sec:resolvable-consumable-configs
  isCanBeConsumed = false
  isCanBeResolved = false
  description = "A configuration to declare platform (version constraints) in every other resolvable configurations"
}

configurations {
  // some configurations unfortunately do not extend from implementation, nor should they be.
  // so we are making [versionConstraints] a global configuration that sets the version constraints for all other configurations.
  // see https://docs.gradle.org/current/userguide/java_plugin.html#tab:configurations
  listOf("implementation", "compileOnly", "runtimeOnly", "annotationProcessor", "testCompileOnly").forEach {
    getByName(it).extendsFrom(versionConstraints)
  }
}

dependencies {
  // you can import our platform even if the platform itself is not resolvable here,
  // e.g. not included in this gradle/plugins build project
  // but as long as the actual main project which uses this plugin,
  // has the root settings.gradle.kts includeBuild("our platform"), (see the root settings.gradle.kts)
  // then this platform will be resolved.
  // Btw, this is also the great workaround for issue https://github.com/gradle/gradle/issues/15383 before Gradle 8.5 was out,
  // but it only works in dependencies {} block
  versionConstraints(platform("poc.cx.glp:dev-version-constraints"))
}
