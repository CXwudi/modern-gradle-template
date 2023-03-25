plugins {
  id("my.jvm-root")
}

dependencies {
  testImplementation(platform("io.kotest:kotest-bom"))
  testImplementation("io.kotest:kotest-runner-junit5")
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
}
