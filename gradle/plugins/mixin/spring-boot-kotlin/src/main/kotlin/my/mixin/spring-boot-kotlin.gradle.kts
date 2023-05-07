package my.mixin

import my.mixin.springboot.kotlin.MockFramework
import my.mixin.springboot.kotlin.MySpringBootKotlinExtension

/**
 * require kotlin-mixin and spring-boot-mixin
 */
plugins {
  id("my.root.jvm")
  kotlin("plugin.spring")
}

dependencies {
  implementation("com.github.CXwudi:kotlin-jvm-inline-logging")
  testImplementation("io.kotest.extensions:kotest-extensions-spring")
  // due to https://github.com/Ninja-Squad/springmockk#limitations, mockk and springmockk are not added by default here,
  // use my.spring-boot-mockk-mixin to add mockk instead
}

extensions.create<MySpringBootKotlinExtension>("mySpringBootKotlin")

afterEvaluate {
  val ext = this.extensions.getByType<MySpringBootKotlinExtension>()
  when (ext.mockFramework.get()) {
    MockFramework.MOCKITO -> {
      this.dependencies {
        testImplementation("org.mockito.kotlin:mockito-kotlin")
      }
    }

    MockFramework.MOCKK -> {
      this.configurations {
        all {
          exclude(group = "org.mockito")
          exclude(group = "org.mockito.kotlin")
        }
      }
      this.dependencies {
        testImplementation("io.mockk:mockk")
        testImplementation("com.ninja-squad:springmockk")
      }
    }
  }
}
