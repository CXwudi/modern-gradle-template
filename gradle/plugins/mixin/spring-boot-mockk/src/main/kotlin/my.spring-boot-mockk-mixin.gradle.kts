/**
 * This plugin is optional for kotlin spring boot projects that want to use mockk.
 *
 * requires kotlin-mixin, spring-boot-mixin, and spring-boot-kotlin-mixin
 */
plugins {
  id("my.jvm-root")
}

dependencies {
  testImplementation("io.mockk:mockk")
  testImplementation("com.ninja-squad:springmockk")
}

/**
 * Given user an option to exclude mockito from the classpath.
 * @property excludeMockito `Property<Boolean>` default is false to not exclude
 */
abstract class MySpringBootMockkExtension {
  abstract val excludeMockito: Property<Boolean>

  init {
    excludeMockito.convention(false)
  }
}

extensions.create<MySpringBootMockkExtension>("springBootMockk")

// use afterEvaluate to make sure this piece of logic is executed 
// after all plugins and other configurers from the main build is applied
afterEvaluate {
  this.extensions.getByType(MySpringBootMockkExtension::class.java).let { ext ->
    if (ext.excludeMockito.get()) {
      this.configurations {
        all {
          exclude(group = "org.mockito")
        }
      }
    }
  }
}
