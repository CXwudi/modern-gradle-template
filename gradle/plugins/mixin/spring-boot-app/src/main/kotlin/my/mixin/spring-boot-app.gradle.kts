package my.mixin

import my.mixin.springboot.app.MySpringBootAppExtension
import my.mixin.springboot.app.MySpringBootLoggingFramework
import my.mixin.springboot.app.internal.determineEffectiveLoggingFramework
import org.springframework.boot.gradle.plugin.SpringBootPlugin
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
tasks.named<BootJar>(SpringBootPlugin.BOOT_JAR_TASK_NAME) {
  archiveClassifier.set("boot")
}

tasks.named<Jar>(JavaPlugin.JAR_TASK_NAME) {
  archiveClassifier.set("")
}

extensions.create<MySpringBootAppExtension>("mySpringBootApp")

afterEvaluate {
  val ext = this.extensions.getByType(MySpringBootAppExtension::class.java)

  val effectiveChoice = determineEffectiveLoggingFramework(ext)
  if (effectiveChoice == MySpringBootLoggingFramework.LOG4J2) {
    // we must use the configuration excluding method because the spring lib could still be using logback,
    // and it makes sense that the user would only want to change the logging framework on the app side
    // so that all spring lib modules can use whatever the spring app wants to use.
    this.configurations {
      all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
      }
    }
    this.dependencies {
      add("implementation", "org.springframework.boot:spring-boot-starter-log4j2")
    }
  }
}
