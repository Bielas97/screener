plugins {
    id("com.screener.static")
    id("com.screener.common")
    kotlin("plugin.spring")
}

group = "com.screener"

val catalogs = extensions.getByType<VersionCatalogsExtension>()
val libs = catalogs.named("libs")

dependencies {
    implementation(libs.findLibrary("spring-starter-webflux").get())
    implementation(libs.findLibrary("kotlinx-coroutines-core").get())
    implementation(libs.findLibrary("kotlinx-coroutines-reactor").get())
    implementation(libs.findLibrary("jackson-module-kotlin").get())
}