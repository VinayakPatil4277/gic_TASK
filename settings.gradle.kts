pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // This line causes the warning
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
//            from(files("gradle/libs.versions.toml"))
        }
    }
}

rootProject.name = "gic_TASK"
include(":app")