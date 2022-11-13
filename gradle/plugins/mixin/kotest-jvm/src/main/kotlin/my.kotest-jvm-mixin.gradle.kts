plugins {
  id("my.jvm-root")
}

dependencies {
  testImplementation("io.kotest:kotest-runner-junit5")
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
}
