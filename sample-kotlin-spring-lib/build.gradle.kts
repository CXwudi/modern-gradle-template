import my.mixin.springboot.MySpringBootLoggingFramework

plugins {
  id("my.kotlin-spring-lib")
}

mySpringBoot {
  loggingFramework.set(MySpringBootLoggingFramework.LOGBACK)
}
