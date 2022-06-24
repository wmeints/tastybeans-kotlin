pluginManagement{
    repositories {
        gradlePluginPortal()
    }

    includeBuild("../build-logic")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

includeBuild("../platforms")

rootProject.name = "shared"

include("domain")
include("application")
include("infrastructure")