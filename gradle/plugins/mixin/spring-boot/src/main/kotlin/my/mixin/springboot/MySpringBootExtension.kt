package my.mixin.springboot

import org.gradle.api.provider.Property

abstract class MySpringBootExtension {
  abstract val loggingFramework: Property<MySpringBootLoggingFramework>

  init {
    loggingFramework.convention(MySpringBootLoggingFramework.LOG4J2)
  }
}

enum class MySpringBootLoggingFramework {
  LOG4J2, LOGBACK
}
