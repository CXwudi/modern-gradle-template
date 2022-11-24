/**
 * This is the root plugin that every other plugin uses, and there should be only one root plugin
 */
plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  // the platform needs to be applied to every build.gradle.kts file in this gradle/plugins folder
  // that requires dependency version to be resolved by platform("poc.cx.glp:dev-version-constraints").
  // by defining api(platform()) on this root precompiled plugins,
  // all other plugins will have access to the platform.
  // as long as it uses implementation() or other configurations that is extended from api()
  api(platform("poc.cx.glp:plugin-version-constraints"))

  // another way 1 is to includeBuild() yet another plugin build inside this plugin build's settings.gradle.kts,
  // and group `kotlin-dsl` and 'platform("poc.cx.glp:dev-version-constraints")' into another plugin
  // and replace `kotlin-dsl` with that new plugin.

  // another way 2 is to use version catalog, but it is uglier in my opinion
}
