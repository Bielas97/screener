plugins {
    kotlin("jvm")
}

val catalogs = extensions.getByType<VersionCatalogsExtension>()
val libs = catalogs.named("libs")

dependencies {
    implementation(libs.findLibrary("kotlin-logging-jvm").get())
    implementation(libs.findLibrary("logback-json-classic").get())
    implementation(libs.findLibrary("kotlinx-coroutines-slf4j").get())
    implementation(libs.findLibrary("logstash-logback-encoder").get())
}