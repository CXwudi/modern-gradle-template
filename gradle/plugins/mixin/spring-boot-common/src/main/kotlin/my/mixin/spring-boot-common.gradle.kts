package my.mixin

plugins {
  id("my.root.jvm")
  // note: the spring-boot-gradle-plugin is not applied as it is for setting up the spring-app,
  // but here we are setting up the spring mixin.
  // the io.spring.dependency-management plugin forces to use the bom version
  // it defines from spring-boot-gradle-plugin.
  // so we are just using the platform("org.springframework.boot:spring-boot-dependencies") directly.
//  id("io.spring.dependency-management")
}

fun DependencyHandlerScope.sbs(dep: String? = null, version: String? = null) =
  "org.springframework.boot:spring-boot-starter${dep?.let { "-$it" } ?: ""}${version?.let { ":$it" } ?: ""}"

dependencies {
  versionConstraints(platform("org.springframework.boot:spring-boot-dependencies"))
  implementation(sbs())
  // both spring lib and app potentially need this.
  // for spring app, adding this gives intellij auto-complete for application.yml
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  // with spring boot, you are pretty much fixed to use spring-boot-starter-test, which uses junit 5,
  // so don't bother extracting spring-boot-starter-test to a separate mixin...
  testImplementation(sbs("test"))
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
}

/*
 * In the future, we need to manually configure JVM and Kotlin to match what spring boot gradle plugin configured,
 * see https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#reacting-to-other-plugins.java and
 * https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#reacting-to-other-plugins.kotlin
 * Currently, spring boot only configured UTF-8 and '-parameters' compiler argument.
 * Both are configured in jvm-root and kotlin-jvm-mixin, so we don't need to do anything here.
 *
 * We could have let both spring-app and spring-lib mixin uses spring-boot-gradle-plugin,
 * but that would cause all spring lib modules containing a lot of tasks that are only needed for spring app,
 * such as bootJar, bootRun, etc.
 */
