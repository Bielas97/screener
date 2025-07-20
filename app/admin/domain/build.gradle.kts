plugins {
    id("com.screener.static")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}