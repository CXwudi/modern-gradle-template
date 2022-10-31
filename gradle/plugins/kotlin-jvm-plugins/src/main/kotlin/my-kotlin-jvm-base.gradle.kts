import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("my-java-base")
  kotlin("jvm")
}

configurations {
  all { // we don't need lombok in kotlin, unless we want to use it in the java code in the kotlin project
    exclude("org.projectlombok", "lombok")
  }
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm")

  testImplementation("io.kotest:kotest-runner-junit5")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    // without jvmTarget, by default will be java toolchain version
  }
}
