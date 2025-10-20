plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.dokka.gradlePlugin)
    implementation(libs.gradleMavenPublish)
    implementation(gradleKotlinDsl())

    // TODO: https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))}

java.toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
}