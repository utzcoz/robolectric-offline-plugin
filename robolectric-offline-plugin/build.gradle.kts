plugins {
  // Apply the Java Gradle plugin development plugin to add support for developing Gradle plugins
  `java-gradle-plugin`
  id("com.diffplug.spotless") version "6.23.3"
}

repositories {
  // Use Maven Central for resolving dependencies
  mavenCentral()
}

spotless {
  kotlin {
    target("**/*.gradle")
    targetExclude("**/build/*.gradle")
    ktfmt()
  }

  kotlinGradle {
    target("*.gradle.kts", "**/*.gradle.kts")
    ktfmt()
  }
}

dependencies {
  // Use JUnit test framework for unit tests
  testImplementation("junit:junit:4.13.2")
}

gradlePlugin {
  // Define the plugin
  val greeting by
      plugins.creating {
        id = "com.example.plugin.greeting"
        implementationClass = "com.example.plugin.GreetingPlugin"
      }
}

// Add a source set and a task for a functional test suite
val functionalTest by sourceSets.creating

gradlePlugin.testSourceSets(functionalTest)

configurations[functionalTest.implementationConfigurationName].extendsFrom(
    configurations.testImplementation.get())

val functionalTestTask =
    tasks.register<Test>("functionalTest") {
      testClassesDirs = functionalTest.output.classesDirs
      classpath =
          configurations[functionalTest.runtimeClasspathConfigurationName] + functionalTest.output
    }

tasks.check {
  // Run the functional tests as part of `check`
  dependsOn(functionalTestTask)
}