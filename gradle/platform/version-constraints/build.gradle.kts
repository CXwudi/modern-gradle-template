plugins {
  id("java-platform")
}

group = "poc.cx.glp"

javaPlatform {
  allowDependencies()
}

dependencies {
  // add your maven bom or gradle platform here and add the version to libs.versions.toml file

  // benefit from spring boot's version management for non-spring projects
  // see https://docs.spring.io/spring-boot/docs/current/reference/html/dependency-versions.html to check what lib is included
  api(platform("org.springframework.boot:spring-boot-dependencies:${libs.versions.springBoot.get()}"))
//  api(platform("org.jetbrains.kotlinx:kotlinx-coroutines-bom:1.6.4")) // enable if spring screws up coroutines
  api(platform("io.kotest:kotest-bom:${libs.versions.kotest.get()}"))
  constraints {
    // add your api() here to manage dependency and add the version to libs.versions.toml file
    api("com.github.CXwudi:kotlin-jvm-inline-logging:${libs.versions.kInlineLogging.get()}")
    api("io.kotest.extensions:kotest-extensions-spring:${libs.versions.kotestSpring.get()}")
    api("com.ninja-squad:springmockk:${libs.versions.springMockk.get()}")
  }
}
