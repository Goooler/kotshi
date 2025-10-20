pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenLocal()
    }
    includeBuild("gradle-plugin")
}

plugins {
    id("com.gradle.develocity") version "4.2.2"
}

develocity {
    buildScan {
        termsOfUseUrl = "https://gradle.com/terms-of-service"
        termsOfUseAgree = "yes"
        // TODO: https://github.com/gradle/gradle/issues/22879
        val isCI = providers.environmentVariable("CI").isPresent
        publishing.onlyIf { isCI }
    }
}

rootProject.name = "kotshi"

include("compiler")
include("api")
include("tests")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}
