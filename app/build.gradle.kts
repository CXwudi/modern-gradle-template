plugins {
  id("my.kotlin-jvm-app")
}

dependencies {
  implementation(project(":lib"))
  implementation("org.apache.commons:commons-lang3")
}

application {
  mainClass.set("poc.cx.glp.app.MainKt")
}
