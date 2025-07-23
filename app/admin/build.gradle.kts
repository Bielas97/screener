plugins {
    id("org.springframework.boot")
    id("com.screener.springboot")
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}


dependencies {
    implementation(project(":admin:domain"))
    implementation(project(":admin:application"))
    implementation(project(":admin:adapters"))
    implementation(project(":admin:adapters:yodeck"))
    implementation(project(":admin:adapters:web"))
}

task("buildFatJar") {
    dependsOn("bootJar")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}