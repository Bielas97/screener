plugins {
    id("com.screener.static")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.logging.jvm)
    implementation(libs.springdoc.ui)
    implementation(libs.kotlinx.coroutines.reactor)
}

tasks.test {
    useJUnitPlatform()
}