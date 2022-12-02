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

Modify the project name in `rootProject.name` in [`settings.gradle.kts`](settings.gradle.kts) to your own project name,
and globally change the group name `poc.cx.glp` to your own group name.
The group name `poc.cx.glp` is defined
in [`dev-version-constraints`](gradle/platform/dev-version-constraints/build.gradle.kts)
and [`plugin-version-constraints`](gradle/platform/plugin-version-constraints/build.gradle.kts) module
and is referred several places in  [`gradle/plugins/`](gradle/plugins) directories.

Now you can just delete the three main subproject `sample-java-lib`, `sample-kotlin-app` and `sample-kotlin-spring-app`,
and add your own main project 😉
