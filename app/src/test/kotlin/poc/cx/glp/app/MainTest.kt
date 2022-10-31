package poc.cx.glp.app

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertDoesNotThrow

class MainTest : ShouldSpec({
  context("a test") {
    should("pass") {
      assertDoesNotThrow { main() }
      true shouldBe true
    }
  }
})
