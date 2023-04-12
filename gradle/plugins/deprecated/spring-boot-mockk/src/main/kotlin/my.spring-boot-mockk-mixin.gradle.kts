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
    excludeMockito.convention(true)
  }
}

extensions.create<MySpringBootMockkExtension>("mySpringBootMockk")

// use afterEvaluate to make sure this piece of logic is executed 
// after all plugins and other configurers from the main build is applied.
// however, afterEvaluate should not be preferred as multiple plugins with afterEvaluate can cause unexpected behavior.
// see https://discuss.gradle.org/t/is-project-afterevaluate-the-proper-way-for-gradle-plugin-to-dynamically-create-default-tasks/31349/2
afterEvaluate {
  val ext = this.extensions.getByType(MySpringBootMockkExtension::class.java)
  if (ext.excludeMockito.get()) {
    this.configurations {
      all {
        exclude(group = "org.mockito")
        exclude(group = "org.mockito.kotlin")
      }
    }
  }
}
