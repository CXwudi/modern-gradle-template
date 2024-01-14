# modern-gradle-template

I learn Gradle because I want a simplified syntax to describe a multi-module project, so I payed and learned
from [Udemy](https://www.udemy.com/course/modern-gradle-fundamentals/)

But I end up with this crazy setup that is 10x more complicated than
my [current maven multi-module project setup](https://github.com/CXwudi/vocadb-video-downloader-new) 😂

Definitely overkilled for small, personal, or school projects...

## How crazy 😲 is this template

See how I structured my precompiled script plugins

![image](gradle/plugins/gradle%20plugins%20structure.drawio.png)

Also, each module is an independent submodule in the `gradle/plugins` build source project,
and each module in the same layer will never depend on each other.

This is explicitly designed to boost build performance from gradle parallel execution.

![performance boost](https://s2.loli.net/2022/11/07/P6xpd5IC7HZksJu.png)

## I want to use this template

Thanks for considering my template 🙂, just do the following things, and you are good to go:

1. Delete these sample submodules begin with `sample-`, and update the logic of including submodules in the
   root [`settings.gradle.kts`](settings.gradle.kts)
2. Modify the project name `rootProject.name` in [`settings.gradle.kts`](settings.gradle.kts) to your own project name.
3. Globally change the group name `poc.cx.glp` to your own group name.
   The group name `poc.cx.glp` is defined in [`dev-version-constraints`](gradle/platform/dev-version-constraints/build.gradle.kts)
   module
   and is referred in the [root plugin](gradle/plugins/root/src/main/kotlin/my/root/jvm.gradle.kts) and
   the [lib mixin plugin](gradle/plugins/mixin/lib/src/main/kotlin/my/mixin/lib.gradle.kts).
4. Delete everything in [mixin plugins folder](gradle/plugins/mixin) and [convention plugins folder](gradle/plugins/convention),
   and delete everything in the [version catalog](gradle/libs.versions.toml),
   and delete everything in the `constraints` block in
   the [`dev-version-constraints` platform](gradle/platform/dev-version-constraints/build.gradle.kts)
   - Tips: you can choose to not delete some stuff if you find them useful
5. Add your own mixin plugins and convention plugins, and don't forget to archive centralized version management by adding your
   own libraries into the version catalog.
   - Tips: if you want to use version catalog in precompiled script plugins (mixin plugins),
     put them in the `constraints` block in
     the [`dev-version-constraints` platform](gradle/platform/dev-version-constraints/build.gradle.kts).
     Then in precompiled script plugins, declare the library dependency without the version
     (e.g. `implementation("org.springframework.boot:spring-boot-starter")`).

This template also contains two ways for updating library dependencies automatically,
either by using renovate bot (recommended as it is the only tool that support Gradle version catalog so far),
or running Gradle tasks defined in the root [`build.gradle.kts`](build.gradle.kts)
