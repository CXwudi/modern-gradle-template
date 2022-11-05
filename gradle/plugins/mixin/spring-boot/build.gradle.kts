plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(project(":root"))
  // this needs to apply to every build.gradle.kts file in this gradle/plugins folder
  // that requires dependency version to be resolved by platform("poc.cx.glp:version-constraints")
  // another way 1 is to includeBuild() yet another plugin build inside this plugin build's settings.gradle.kts,
  // and group `kotlin-dsl` and 'platform("poc.cx.glp:version-constraints")' into the another plugin
  // and replace `kotlin-dsl` with that new plugin.
  // another way 2 is to use version catalog, but it is more ulgry in my opinion
  implementation(platform("poc.cx.glp:version-constraints"))
  implementation("io.spring.gradle:dependency-management-plugin")
}
