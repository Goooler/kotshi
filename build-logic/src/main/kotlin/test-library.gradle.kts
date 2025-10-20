import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    id("library")
}

val libs = the<LibrariesForLibs>()

dependencies {
    implementation(project(":api"))
    implementation(project(":compiler"))
    if (providers.gradleProperty("kotshi.internal.useLegacyMoshi").orNull?.toBooleanStrict() == true) {
        compileOnly(libs.moshi.latest)
        testImplementation(libs.oldestSupportedMoshi)
    } else {
        implementation(libs.moshi.latest)
    }
    compileOnly(libs.findBugs)
    testImplementation(libs.compileTesting.core)
}