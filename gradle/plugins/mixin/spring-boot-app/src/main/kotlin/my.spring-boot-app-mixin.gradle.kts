import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  id("org.springframework.boot")
}

// taken from https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#packaging-executable.and-plain-archives
tasks.named<BootJar>("bootJar") {
  archiveClassifier.set("boot")
}

tasks.named<Jar>("jar") {
  archiveClassifier.set("")
}
