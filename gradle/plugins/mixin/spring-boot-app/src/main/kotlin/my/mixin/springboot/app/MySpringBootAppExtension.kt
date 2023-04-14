package my.mixin.springboot.app

import org.gradle.api.provider.Property

abstract class MySpringBootAppExtension {
  /**
   * The choice of logging framework for the spring boot app.
   * It can be either [MySpringBootLoggingFramework.LOG4J2] or [MySpringBootLoggingFramework.LOGBACK]
   *
   * However, if graalvm native plugin is applied, then it will be forced to [MySpringBootLoggingFramework.LOGBACK],
   * unless [forceUseChosenLoggingFramework] is set to `true`.
   */
  abstract val loggingFramework: Property<MySpringBootLoggingFramework>

  /**
   * If set to `true`, then the logging framework will be forced to the value of [loggingFramework].
   *
   * The Existence of the graalvm native plugin will be ignored.
   */
  abstract val forceUseChosenLoggingFramework: Property<Boolean>

  init {
    loggingFramework.convention(MySpringBootLoggingFramework.LOG4J2)
    forceUseChosenLoggingFramework.convention(false)
  }
}

enum class MySpringBootLoggingFramework {
  LOG4J2, LOGBACK
}
