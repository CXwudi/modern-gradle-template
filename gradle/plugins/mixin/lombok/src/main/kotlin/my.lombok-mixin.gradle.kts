plugins {
  id("my.jvm-root")
  id("io.freefair.lombok") // using a dedicated community lombok plugin from https://plugins.gradle.org/plugin/io.freefair.lombok
}

dependencies {
  // optional but recommended, force the "lombok" configuration from the community lombok plugin
  // to use our own version of lombok, even if the plugin uses a newer version.
  // compileOnly and annotationProcessor already extended from the "lombok" configuration
  lombok(platform("poc.cx.glp:dev-version-constraints"))
  lombok("org.projectlombok:lombok")
  // without plugin, it would be
  // annotationProcessor("org.projectlombok:lombok")
}

// couldn't make it work
// lombok {
//  configurations.annotationProcessor.get().dependencies
//    .find { it.group == "org.projectlombok" }
//    ?.version?.let {
//      version.set(it)
//    }
// }
