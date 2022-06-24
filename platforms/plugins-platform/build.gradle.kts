plugins {
    id("java-platform")
}

group = "com.tastybeans.platform"

dependencies {
    constraints {
        api("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:1.7.0")
        api("org.jetbrains.kotlin.plugin.allopen:org.jetbrains.kotlin.plugin.allopen.gradle.plugin:1.7.0")
        api("org.springframework.boot:org.springframework.boot.gradle.plugin:2.7.1")
    }
}
