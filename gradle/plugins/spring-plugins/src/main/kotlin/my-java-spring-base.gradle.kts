plugins {
  id("my-java-base")
  id("org.springframework.boot") apply false
  id("io.spring.dependency-management") apply false
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
