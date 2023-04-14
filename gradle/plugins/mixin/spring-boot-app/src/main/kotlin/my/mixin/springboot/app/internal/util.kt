package my.mixin.springboot.app.internal

import my.mixin.springboot.app.MySpringBootAppExtension
import my.mixin.springboot.app.MySpringBootLoggingFramework
import org.gradle.api.Project

/**
 * Determine the effective logging framework choice
 * @receiver Project the project
 * @param ext MySpringBootAppExtension the extension
 * @return MySpringBootLoggingFramework the effective choice
 */
fun Project.determineEffectiveLoggingFramework(ext: MySpringBootAppExtension): MySpringBootLoggingFramework = if (
  ext.loggingFramework.get() == MySpringBootLoggingFramework.LOG4J2 &&
  this.plugins.hasPlugin("org.graalvm.buildtools.native")
) {
  // check if the user forces choosing log4j2 despite the fact that graalvm native plugin is applied
  if (ext.forceUseChosenLoggingFramework.get()) {
    MySpringBootLoggingFramework.LOG4J2
  } else {
    MySpringBootLoggingFramework.LOGBACK
  }
} else {
  ext.loggingFramework.get()
}
