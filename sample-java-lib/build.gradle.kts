plugins {
  // java library
  id("my.java-lib") // same as id("java-library) already included id("java")
  // id("java") // the core java plugin
}

dependencies {
  versionConstraints(platform("org.springframework.boot:spring-boot-dependencies"))
  implementation("org.apache.commons:commons-lang3")
}
