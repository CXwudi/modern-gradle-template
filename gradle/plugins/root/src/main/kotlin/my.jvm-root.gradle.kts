/**
 * The root plugin only defines the java version, dependency version constraints and a new configuration called [annotationProcessorAndCompileOnly].
 */
plugins {
  java
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(17))
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

dependencies {
  // you can import our platform even if the platform itself is not included in this gradle/plugins build project
  // because the actual main project which uses this plugin,
  // which has the root settings.gradle.kts includeBuild("our platform"), can resolve it.
  implementation(platform("poc.cx.glp:dev-version-constraints"))
  // some configurations unfortunately do not extend from implementation, nor should they be.
  // so we manually add the platform in, see https://docs.gradle.org/current/userguide/java_plugin.html#tab:configurations
  annotationProcessor(platform("poc.cx.glp:dev-version-constraints"))
  runtimeOnly(platform("poc.cx.glp:dev-version-constraints"))
  compileOnly(platform("poc.cx.glp:dev-version-constraints"))
  // also api() and compileOnlyApi(), but they are added in my.lib-mixin
}
