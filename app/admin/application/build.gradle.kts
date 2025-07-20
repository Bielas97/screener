plugins {
    id("com.screener.springboot")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(project(":admin:domain"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}