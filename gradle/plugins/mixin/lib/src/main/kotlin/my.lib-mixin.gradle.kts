plugins {
  id("my.jvm-root")
  `java-library`
}

java {
  withSourcesJar()
}

dependencies {
  // similar story in my.jvm-root mixin
  api(platform("poc.cx.glp:dev-version-constraints"))
  compileOnlyApi(platform("poc.cx.glp:dev-version-constraints"))
}
