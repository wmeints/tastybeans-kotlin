plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(platform("com.tastybeans.platform:plugins-platform"))
    implementation(project(":commons"))
    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin")
    implementation("org.jetbrains.kotlin.plugin.allopen:org.jetbrains.kotlin.plugin.allopen.gradle.plugin")
    implementation("org.springframework.boot:org.springframework.boot.gradle.plugin")
}