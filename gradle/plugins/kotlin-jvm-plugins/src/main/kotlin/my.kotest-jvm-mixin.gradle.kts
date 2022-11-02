plugins {
  id("my.java-root")
}

dependencies {
  testImplementation("io.kotest:kotest-runner-junit5")
}

tasks.withType<Test> {
  useJUnitPlatform()
}
