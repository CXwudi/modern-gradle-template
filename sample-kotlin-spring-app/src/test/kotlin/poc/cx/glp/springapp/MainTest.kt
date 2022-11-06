package poc.cx.glp.springapp

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertDoesNotThrow
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MainTest(
  private val main: Main,
) : ShouldSpec({

  context("the main") {
    should("run") {
      assertDoesNotThrow { main.run() }
      true shouldBe true
    }
  }
})
