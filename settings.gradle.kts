pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "MediaPlayer"
include(":app")

fileTree("features")
    .filter { file -> file.name == "build.gradle.kts" }
    .forEach { file ->
        val moduleName = file.parentFile.name
        include(moduleName)
        project(":$moduleName").projectDir = file.parentFile
    }
