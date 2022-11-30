/**
 * This add-in plugin is optional for spring boot app with gradle application plugin added.
 *
 * This plugin would let the bootStartScripts task output be stored at the root directory of the distribution output.
 *
 * requires spring-boot-mixin, spring-boot-app-mixin, and app-mixin
 */
// adding this can force the spring boot start script to be generated in root directory of the distribution
// instead of bin/ directory
// but this is kind of useless because if you need the start script,
// why not just use gradle's application plugin?
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
