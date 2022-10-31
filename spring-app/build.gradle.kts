plugins {
  id("my-kotlin-spring-app")
}

dependencies {
  implementation(project(":lib"))
  implementation("com.github.CXwudi:kotlin-jvm-inline-logging")
}

application { // prefer to use gradle way to set main class, instead of relying on spring finding it
  mainClass.set("poc.cx.glp.springapp.MainAppKt")
}
