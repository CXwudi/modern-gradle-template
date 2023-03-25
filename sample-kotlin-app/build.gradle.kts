plugins {
  id("my.kotlin-jvm-app")
}

dependencies {
  versionConstraints(platform("org.springframework.boot:spring-boot-dependencies"))
  implementation(project(":sample-java-lib"))
  implementation("org.apache.commons:commons-lang3")
}

application {
  mainClass.set("poc.cx.glp.app.MainKt")
}
