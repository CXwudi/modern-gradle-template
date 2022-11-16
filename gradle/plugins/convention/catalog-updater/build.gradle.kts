plugins {
  `kotlin-dsl` // !id("kotlin-dsl"), this tells gradle to use kotlin dsl
}

dependencies {
  implementation(platform("poc.cx.glp:version-constraints"))
  implementation("com.github.ben-manes:gradle-versions-plugin")
  implementation("nl.littlerobots.vcu:plugin")
}
