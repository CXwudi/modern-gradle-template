package poc.cx.glp.springapp

import mikufan.cx.inlinelogging.KInlineLogging
import org.springframework.beans.factory.getBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import poc.cx.glp.lib.OldMessageModel

/**
 * 2022-10-29
 * @author CX无敌
 */
@SpringBootApplication
class MainApp

fun main() {
  runApplication<MainApp>().use { it.getBean<Main>().run() }
}

@Component
class Main : Runnable {
  override fun run() {
    log.info { OldMessageModel("Hello, world!") }
  }

  companion object {
    @JvmStatic
    private val log = KInlineLogging.logger()
  }
}
