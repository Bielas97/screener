plugins {
    id("com.screener.springboot")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation(project(":admin:domain"))
    implementation(project(":admin:application"))
    implementation(project(":admin:adapters:yodeck"))

    implementation(project(":util"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}