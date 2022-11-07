/**
 * This add-in plugin is optional and only applicable for main projects that applied both my.spring-boot-app-mixin and my.app-mixin.
 *
 * This plugin would let the bootStartScripts task output be stored at the root directory of the distribution output.
 */
plugins {
  id("org.springframework.boot")
  application
}

val destPath = ""
// 1. let the bootStartScripts use executableDir = ""
val bootStartScriptTask = tasks.named<org.gradle.jvm.application.tasks.CreateStartScripts>("bootStartScripts") {
  // u can customize the start script here
  // see https://docs.gradle.org/current/dsl/org.gradle.jvm.application.tasks.CreateStartScripts.html
  executableDir = destPath
}

// 2. modify the boot distribution to exclude the start script in bin/ folder,
// and include the start script in root folder
distributions {
  boot {
    contents {
      eachFile {
        if (this.relativePath.segments[0] == "bin") {
          exclude()
        }
      }
      from(bootStartScriptTask) {
        into(destPath)
      }
    }
  }
}
