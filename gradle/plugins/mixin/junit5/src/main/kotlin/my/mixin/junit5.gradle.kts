package my.mixin

plugins {
  id("my.root.jvm")
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api") // api is needed in both compile and runtime
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine") // but the engine is only needed at runtime
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
}
