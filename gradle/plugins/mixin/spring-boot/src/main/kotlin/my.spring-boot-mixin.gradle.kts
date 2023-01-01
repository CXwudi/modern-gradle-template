import my.mixin.springboot.MySpringBootExtension
import my.mixin.springboot.MySpringBootLoggingFramework

plugins {
  id("my.jvm-root")
  // note: the spring-boot-gradle-plugin is not applied as it is for setting up the spring-app,
  // but here we are setting up the spring mixin,
  // so only adding the dependency-management plugin and some common spring-boot-starter dependencies.
  // in fact, even the dependency-management plugin is optional, since our own 'version-constraints' platform
  // already included the bom of spring-boot
  id("io.spring.dependency-management")
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter")
  // both spring lib and app potentially need this.
  // for spring app, adding this gives intellij auto-complete for application.yml
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
  // with spring boot, you are pretty much fixed to use spring-boot-starter-test, which uses junit 5,
  // so don't bother extracting spring-boot-starter-test to a separate mixin...
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
}

/*
 * In the future, we need to manually configure JVM and Kotlin to match what spring boot gradle plugin configured,
 * see https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#reacting-to-other-plugins.java and
 * https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#reacting-to-other-plugins.kotlin
 * Currently, spring boot only configured UTF-8 and '-parameters' compiler argument.
 * Both are configured in jvm-root and kotlin-jvm-mixin, so we don't need to do anything here.
 *
 * We could have let both spring-app and spring-lib mixin uses spring-boot-gradle-plugin,
 * but that would cause all spring lib modules containing a lot of tasks that are only needed for spring app,
 * such as bootJar, bootRun, etc.
 */

extensions.create<MySpringBootExtension>("mySpringBoot")

afterEvaluate {
  val ext = this.extensions.getByType(MySpringBootExtension::class.java)
  if (ext.loggingFramework.get() == MySpringBootLoggingFramework.LOG4J2) {
    this.dependencies {
      implementation("org.springframework.boot:spring-boot-starter-log4j2")
      modules {
        module("org.springframework.boot:spring-boot-starter-logging") { // instead of excluding, we can replace one module to another
          replacedBy("org.springframework.boot:spring-boot-starter-log4j2", "Use Log4j2 instead of Logback")
        }
      }
    }
  }
}
