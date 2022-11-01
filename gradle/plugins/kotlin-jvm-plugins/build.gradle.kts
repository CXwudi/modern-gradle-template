plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  val kotlinVersion = libs.versions.kotlin.get()
  implementation(project(":java-plugins"))
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
  implementation("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
}
