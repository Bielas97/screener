plugins {
    kotlin("jvm")
    id("com.diffplug.spotless")
}

group = "com.screener"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

spotless {
    kotlin {
        ktlint()
            .setEditorConfigPath("$rootDir/.editorconfig")
        ktfmt().kotlinlangStyle().configure {
            it.setMaxWidth(120)
        }
        toggleOffOn()
    }
}