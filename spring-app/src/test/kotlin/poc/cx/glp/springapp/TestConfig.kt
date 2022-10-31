package poc.cx.glp.springapp

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.extensions.spring.SpringExtension

/**
 * @date 2022-10-31
 * @author CX无敌
 */
class TestConfig : AbstractProjectConfig() {
  override fun extensions() = listOf(SpringExtension)
}
