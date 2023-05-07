package my.mixin.springboot.kotlin

import org.gradle.api.provider.Property

/**
 * @author CX无敌
 * 2023-04-12
 */
abstract class MySpringBootKotlinExtension {
  abstract val mockFramework: Property<MockFramework>

  init {
    mockFramework.convention(MockFramework.MOCKK)
  }
}

enum class MockFramework {
  MOCKITO,
  MOCKK,
}
