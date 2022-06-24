pluginManagement{
    repositories {
        gradlePluginPortal()
    }

    includeBuild("../../build-logic")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

includeBuild("../../platforms")
includeBuild("../../shared")

rootProject.name = "catalog"

include("domain")
include("application")
include("infrastructure")
include("host")