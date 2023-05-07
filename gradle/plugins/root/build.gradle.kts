/**
 * This is the root plugin that every other plugin uses, and there should be only one root plugin
 */
plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  // three ways to manage dependency versions here:
  // 1. create a gradle platform, and includeBuild() in settings.gradle.kts, then in here do api(platform())
//  api(platform("poc.cx.glp:plugin-version-constraints")) // our old method
  // 2. use version catalog, done in settings.gradle.kts
  // 3. create even a new precompiled plugin that has `kotlin-dsl` plugin applied and our own versioning,
  //   then in settings.gradle.kts, includeBuild() that plugin, and in here apply the plugin
}
