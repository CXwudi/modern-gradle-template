plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(project(":root"))
  implementation("io.freefair.lombok:io.freefair.lombok.gradle.plugin")
}
