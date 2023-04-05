plugins {
  `kotlin-dsl`
}

dependencies {
  api(platform("poc.cx.glp:settings-version-constraints"))
  implementation("com.gradle.enterprise:com.gradle.enterprise.gradle.plugin")
  implementation("org.gradle.toolchains:foojay-resolver")
}
