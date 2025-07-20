pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "screener-app"

include("domain")
include(":util")
include("admin")
include("admin:domain")
include("admin:application")
include("admin:adapters")
include("admin:adapters:web")
include("admin:adapters:yodeck")
