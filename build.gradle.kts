plugins {
  // this plugin must stay at the top-level build script, not in gradle/plugins
  id("com.github.ben-manes.versions") version "0.43.0"
  // an experimental gradle wrapper with JDK downloaded
//  id("me.filippov.gradle.jvm.wrapper") version "0.14.0"
}

// jvmWrapper {
//  linuxX64JvmUrl = "https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.5%2B8/OpenJDK17U-jdk_x64_alpine-linux_hotspot_17.0.5_8.tar.gz"
// }
