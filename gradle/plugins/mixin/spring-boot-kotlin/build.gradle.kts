plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(project(":root"))
  implementation(libs.pluginDep.kotlin)
  implementation(libs.pluginDep.kotlinAllopen)
}
