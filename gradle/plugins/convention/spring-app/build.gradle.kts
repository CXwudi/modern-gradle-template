plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(project(":mixin:spring-boot-common"))
  implementation(project(":mixin:spring-boot-app"))
  implementation(project(":mixin:lombok"))
}
