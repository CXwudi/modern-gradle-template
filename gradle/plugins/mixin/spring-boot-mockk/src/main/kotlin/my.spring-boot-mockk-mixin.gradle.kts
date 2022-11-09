/**
 * This plugin is optional for kotlin spring boot projects that want to use mockk.
 *
 * requires kotlin-mixin, spring-boot-mixin, and spring-boot-kotlin-mixin
 */
plugins {
  id("my.jvm-root")
}

// do not write any exclusion rules here, they will be applied to all projects that use this plugin,
// and nobody knows if the applied project still needs mockito or not.
// configurations {
//   all {
//     exclude(group = "org.mockito")
//   }
// }

dependencies {
  testImplementation("io.mockk:mockk")
  testImplementation("com.ninja-squad:springmockk")
}
