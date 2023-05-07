package my.mixin

plugins {
  id("my.root.jvm")
  id("io.freefair.lombok") // using a dedicated community lombok plugin from https://plugins.gradle.org/plugin/io.freefair.lombok
}

configurations {
  // let the "lombok" configuration from the community lombok plugin
  // using our own version of lombok, even if the plugin uses a newer version.
  // compileOnly and annotationProcessor already extended from the "lombok" configuration
  lombok.get().extendsFrom(versionConstraints.get())
}

// by default, the "lombok" configuration will add a default dependency "org.projectlombok:lombok:<version>"
// iff the "lombok" configuration is empty.
// (see https://github.com/freefair/gradle-plugins/blob/3709c51ac65a64fb94ae350eb08423ec8932e1eb/lombok-plugin/src/main/java/io/freefair/gradle/plugins/lombok/LombokBasePlugin.java#L23)
// so if the main build has used lombok(), then the default dependency will not be added,
// and such a build must manually add lombok("org.projectlombok:lombok:<version>")

// couldn't make it work
// lombok {
//  configurations.annotationProcessor.get().dependencies
//    .find { it.group == "org.projectlombok" }
//    ?.version?.let {
//      version.set(it)
//    }
// }
