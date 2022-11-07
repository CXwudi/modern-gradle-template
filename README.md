# modern-gradle-template

I learn Gradle because I want a simplified syntax to describe a multi-module project, so I payed and learned from [Udemy](https://www.udemy.com/course/modern-gradle-fundamentals/)

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

Thanks for considering my template 🙂

Modify the `rootProject.name` in [`settings.gradle.kts`](settings.gradle.kts)
and modify the group name of the `version-constraints` module
in [`gradle/platform/version-constarins/build.gradle.kts`](gradle/platform/version-constraints/build.gradle.kts)
as well as the reference to group name
in [`gradle/plugins/root/src/main/kotlin/my.jvm-root.gradle.kts`](gradle/plugins/root/src/main/kotlin/my.jvm-root.gradle.kts)

Now you can just delete the three main subproject `sample-java-lib`, `sample-kotlin-app` and `sample-kotlin-spring-app`,
and add your own main project 😉
