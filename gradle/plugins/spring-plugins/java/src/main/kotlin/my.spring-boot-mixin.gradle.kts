plugins {
  id("my.jvm-root")
  // note: the spring-boot-gradle-plugin is not applied as it is for setting up the spring-app,
  // but here we are setting up the spring mixin,
  // so only adding the dependency-management plugin and some common spring-boot-starter dependencies.
  // in fact, even the dependency-management plugin is optional, since our own 'version-constraints' platform
  // already included the bom of spring-boot
  id("io.spring.dependency-management")
}

configurations {
  all { // this is how excluding a dependency across all other dependencies, so that we can use log4j2
    exclude("org.springframework.boot", "spring-boot-starter-logging")
  }
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.springframework.boot:spring-boot-starter-log4j2")
  annotationProcessorAndCompileOnly("org.springframework.boot:spring-boot-configuration-processor") // see my-java-base what has been done instead
  // with spring boot, you are pretty much fixed to use spring-boot-starter-test, which uses junit 5,
  // so don't bother extracting spring-boot-starter-test to a separate mixin...
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
  useJUnitPlatform()
}
