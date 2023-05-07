plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(project(":root"))
  implementation(libs.pplugin.kotlin)
  implementation(libs.pplugin.kotlin.allopen)
}
