# robolectric-offline-plugin

https://docs.gradle.org/current/samples/sample_gradle_plugin.html

:samples-dir: /home/tcagent1/agent/work/64493a816be20d5a/promote-projects/gradle/build/git-checkout/subprojects/docs/build/working/samples/install/gradle-plugin
:gradle-version: 8.5-rc-4

= Gradle Plugin Sample

[.download]
- link:zips/sample_gradle_plugin-groovy-dsl.zip[icon:download[] Groovy DSL]
- link:zips/sample_gradle_plugin-kotlin-dsl.zip[icon:download[] Kotlin DSL]

NOTE: You can open this sample inside an IDE using the https://www.jetbrains.com/help/idea/gradle.html#gradle_import_project_start[IntelliJ native importer] or https://projects.eclipse.org/projects/tools.buildship[Eclipse Buildship].

This sample shows how to build a Gradle plugin in the Java language.

====
include::sample[dir="kotlin",files="greeting-plugin/build.gradle.kts[tags=plugin]"]
include::sample[dir="groovy",files="greeting-plugin/build.gradle[tags=plugin]"]
====

For a more guided tour with plugin development, see link:https://gradle.org/guides/?q=Plugin%20Development[the guides for plugin development].

You can also generate this project locally using link:{userManualPath}/build_init_plugin.html#sec:java_gradle_plugin[`gradle init`].
