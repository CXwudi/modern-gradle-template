plugins {
  id("my.jvm-root")
  `java-library`
}

java {
  withSourcesJar()
}

configurations {
  listOf("api", "compileOnlyApi").forEach {
    getByName(it).extendsFrom(versionConstraints.get())
  }
}
