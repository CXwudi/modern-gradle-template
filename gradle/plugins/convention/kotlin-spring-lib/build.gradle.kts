plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(project(":mixin:kotlin-jvm"))
  implementation(project(":mixin:kotest-jvm"))
  implementation(project(":mixin:spring-boot-common"))
  implementation(project(":mixin:lib"))
  implementation(project(":mixin:spring-boot-kotlin"))
}
