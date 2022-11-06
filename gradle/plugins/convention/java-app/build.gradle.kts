plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(project(":mixin:app"))
  implementation(project(":mixin:lombok"))
  implementation(project(":mixin:junit5"))
}
