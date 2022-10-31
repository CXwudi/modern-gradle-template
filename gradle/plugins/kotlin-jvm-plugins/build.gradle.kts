plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  val kotlinVersion = libs.versions.kotlin.get()
  implementation(project(":java-plugins"))
  api("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
  api("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
}
