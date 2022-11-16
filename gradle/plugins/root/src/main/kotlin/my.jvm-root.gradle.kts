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

/**
 * Inspired from [start.spring.io](https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.7.5&packaging=jar&jvmVersion=17&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=lombok,configuration-processor):
 *
 * ```
 * configurations {
 *   compileOnly {
 *     extendsFrom(configurations.annotationProcessor.get())
 *   }
 * }
 * ```
 *
 * But instead of having all annotationProcessor deps to be added as compileOnly deps,
 * we created a new configuration called [annotationProcessorAndCompileOnly] to extend both [compileOnly] and [annotationProcessor]
 *
 * So that when an annotationProcessor needs to be visible in compile time, like lombok or spring-boot-configuration-processor,
 * we use [annotationProcessorAndCompileOnly] to avoid writing both [annotationProcessor] and [compileOnly] for the same dependency.
 *
 * Otherwise, any dependency that is only needed as annotation processor, like mapstruct, should go to [annotationProcessor] only.
 */
// val annotationProcessorAndCompileOnly: Configuration by configurations.creating
// val testAnnotationProcessorAndCompileOnly: Configuration by configurations.creating
// configurations {
//   compileOnly.get().extendsFrom(annotationProcessorAndCompileOnly)
//   annotationProcessor.get().extendsFrom(annotationProcessorAndCompileOnly)
//   testCompileOnly.get().extendsFrom(testAnnotationProcessorAndCompileOnly)
//   testAnnotationProcessor.get().extendsFrom(testAnnotationProcessorAndCompileOnly)
//   // if a customized source set is added, we need to add the same logic to it
// }

dependencies {
  // you can import our platform even if the platform itself is not included in this gradle/plugins build project
  // because the actual main project which uses this plugin,
  // which has the root settings.gradle.kts includeBuild("our platform"), can resolve it.
  implementation(platform("poc.cx.glp:version-constraints"))
  // some configurations unfortunately do not extend from implementation, nor should they be.
  // so we manually add the platform in, see https://docs.gradle.org/current/userguide/java_plugin.html#tab:configurations
  annotationProcessor(platform("poc.cx.glp:version-constraints"))
  runtimeOnly(platform("poc.cx.glp:version-constraints"))
  compileOnly(platform("poc.cx.glp:version-constraints"))
  // also api() and compileOnlyApi(), but they are added in my.lib-mixin
}
