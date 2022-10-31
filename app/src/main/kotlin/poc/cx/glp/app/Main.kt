package poc.cx.glp.app

import org.apache.commons.lang3.StringUtils
import poc.cx.glp.lib.MessageModel

fun main() {
  println(MessageModel(StringUtils.trim("  Hello World!  ")))
}
