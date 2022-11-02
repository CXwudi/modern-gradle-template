plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(platform("poc.cx.glp:version-constraints"))
  implementation(project(":java-plugins"))
  implementation("org.springframework.boot:spring-boot-gradle-plugin")
  implementation("io.spring.gradle:dependency-management-plugin")
}
