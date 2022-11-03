plugins {
  id("my-java-base")
  id("org.springframework.boot") apply false
  id("io.spring.dependency-management") apply false
  // io.spring.dependency-management is probably not needed since it just adds back the maven dependency management,
  // but gradle 5+ has platform type which acts like maven dependency management,
  // and we already imported spring bom there.
  // see https://stackoverflow.com/questions/57717042/do-we-need-io-spring-dependency-management-gradle-plugin-when-already-using-id
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
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}
