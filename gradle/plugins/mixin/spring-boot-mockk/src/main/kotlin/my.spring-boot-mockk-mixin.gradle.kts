plugins {
  id("my.jvm-root")
}

// let user decide to exclude mockito
// configurations {
//  all {
//    exclude(group = "org.mockito")
//  }
// }

dependencies {
  testImplementation("io.mockk:mockk")
  testImplementation("com.ninja-squad:springmockk")
}
