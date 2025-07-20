plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.allopen)
    implementation(libs.kotlin.serialization)
    implementation(libs.spring.boot.gradle.plugin)
    implementation(libs.dependency.management.plugin)
    implementation(libs.spotless)
    implementation(libs.test.logger)
//    implementation(
//        "org.jetbrains.kotlinx.kover",
//        "org.jetbrains.kotlinx.kover.gradle.plugin",
//        libs.versions.kotlinxKover.get()
//    )
//    implementation("io.gitlab.arturbosch.detekt", "detekt-gradle-plugin", libs.versions.detekt.get())
}