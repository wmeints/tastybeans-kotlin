dependencyResolutionManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
}

includeBuild("../platforms")

rootProject.name = "build-logic"

include("commons")
include("kotlin-library")
include("spring-boot-application")