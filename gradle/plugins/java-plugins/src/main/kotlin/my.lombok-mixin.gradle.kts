plugins {
  id("my.java-root")
}

dependencies {
  // unfortunately, you can only use annotationProcessorAndCompileOnly() in
  annotationProcessorAndCompileOnly("org.projectlombok:lombok")
//  runtimeOnly("org.projectlombok:lombok")
}
