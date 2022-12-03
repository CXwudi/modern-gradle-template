plugins {
  id("my.jvm-root")
  id("io.freefair.lombok") // using a dedicated community lombok plugin from https://plugins.gradle.org/plugin/io.freefair.lombok
}

configurations {
  // optional but recommended, force the "lombok" configuration from the community lombok plugin
  // to use our own version of lombok, even if the plugin uses a newer version.
  // compileOnly and annotationProcessor already extended from the "lombok" configuration
  lombok.get().extendsFrom(versionConstraints.get())
}

dependencies {
  // re-add default deps in lombok configurations shown in https://github.com/freefair/gradle-plugins/blob/1eb1b17924b24c7f9be013fe02ba300e2cf5ae97/lombok-plugin/src/main/java/io/freefair/gradle/plugins/lombok/LombokBasePlugin.java#L23
  lombok("org.projectlombok:lombok")
}

// couldn't make it work
// lombok {
//  configurations.annotationProcessor.get().dependencies
//    .find { it.group == "org.projectlombok" }
//    ?.version?.let {
//      version.set(it)
//    }
// }
