plugins {
    id("com.tastybeans.commons")
    id("org.jetbrains.kotlin.jvm")
    id("java-library")
}

dependencies {
    implementation(platform("com.tastybeans.platform:plugins-platform"))
}