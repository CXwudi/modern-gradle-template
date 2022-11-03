package poc.cx.gradle.task

import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.*

/**
 * 2022-10-28
 * @author CX无敌
 */
// gradle will implement this class
// @CacheableTask. // This tells gradle to cache the task output.
// but it doesn't make sense here because the task output is a file, and our cache strategy will not observe on jar count change.
abstract class JarCount : DefaultTask() {
  // then define input/output here
  @get:InputFiles
  @get:PathSensitive(PathSensitivity.RELATIVE) // @PathSensitive, this tells gradle to use a relative path
  abstract val allJars: ConfigurableFileCollection

  @get:OutputFile
  abstract val countFile: RegularFileProperty

  @TaskAction
  fun doCount() {
    val jarFiles = allJars.files
    val count = jarFiles.size
    val countText = "There are $count jar files in the project"
    countFile.get().asFile.writeText(countText)
  }
}
