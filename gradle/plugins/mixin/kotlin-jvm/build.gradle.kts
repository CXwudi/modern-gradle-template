plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(project(":root"))
  implementation(platform("poc.cx.glp:dev-version-constraints"))
  implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
}
