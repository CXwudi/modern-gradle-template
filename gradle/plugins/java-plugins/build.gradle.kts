plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  // this needs to apply to every build.gradle.kts file in this gradle/plugins folder
  implementation(platform("poc.cx.glp:version-constraints"))
  // another way is to declare yet another plugin build inside this plugin build,
  // and group `kotlin-dsl` and 'platform("poc.cx.glp:version-constraints")' into one plugin
  // and replace `kotlin-dsl` with that new plugin
  implementation(project(":root-plugins"))
}
