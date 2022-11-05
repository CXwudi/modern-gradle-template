plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(project(":mixin:spring-boot"))
  implementation(project(":mixin:lib"))
  implementation(project(":mixin:lombok"))
}
