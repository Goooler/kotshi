plugins {
    id("library")
    alias(libs.plugins.ksp)
}

dependencies {
    implementation(projects.api)
    implementation(projects.compiler)
    ksp(projects.compiler)

    if (providers.gradleProperty("kotshi.internal.useLegacyMoshi").orNull?.toBooleanStrict() == true) {
        compileOnly(libs.moshi.latest)
        testImplementation(libs.oldestSupportedMoshi)
    } else {
        implementation(libs.moshi.latest)
    }
    compileOnly(libs.findBugs)

    testRuntimeOnly(libs.ksp)
    testImplementation(libs.compileTesting.core)
    testImplementation(libs.ksp.api)
    testImplementation(libs.ksp.commonDeps)
    testImplementation(libs.ksp.aaEmbeddable)
    testImplementation(libs.compileTesting.ksp)
}