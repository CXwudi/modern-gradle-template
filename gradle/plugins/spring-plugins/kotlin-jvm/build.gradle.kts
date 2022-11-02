plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(platform("poc.cx.glp:version-constraints"))
  implementation(project(":spring-plugins:java"))
  implementation(project(":kotlin-jvm-plugins"))
}
