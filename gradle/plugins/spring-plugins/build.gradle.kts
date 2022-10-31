plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
//  implementation(project(":java-plugins"))
  implementation(project(":kotlin-jvm-plugins"))
  implementation("org.springframework.boot:spring-boot-gradle-plugin:${libs.versions.springBoot.get()}")
  implementation("io.spring.gradle:dependency-management-plugin:${libs.versions.springDependencyManagement.get()}")
}
