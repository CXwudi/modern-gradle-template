import org.springframework.boot.gradle.tasks.bundling.BootJar

/**
 * requires spring-boot-mixin
 */
plugins {
  // every spring app project must apply this plugin, this plugin is not just simply wrap a boot jar,
  // but also configure kotlin and Java compiler compilation parameters to make json or reflection work correctly.
  // see https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#reacting-to-other-plugins.java.
  // although we could add these parameters manually in jvm-root and kotlin-jvm-mixin
  id("org.springframework.boot")
}

// taken from https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#packaging-executable.and-plain-archives
tasks.named<BootJar>("bootJar") {
  archiveClassifier.set("boot")
}

tasks.named<Jar>("jar") {
  archiveClassifier.set("")
}
