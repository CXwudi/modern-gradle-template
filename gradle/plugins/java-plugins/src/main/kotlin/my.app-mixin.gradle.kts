plugins {
  id("my.java-root")
  application
}

application {
  // we don't want run scripts in bin folder, but at the root of folder
  executableDir = ""
}
