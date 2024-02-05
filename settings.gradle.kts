pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Rick_And_Morty_Multi_Module_App"
include(":app")
include(":database")
include(":data")
include(":domain")
include(":presentation")
include(":remote")
