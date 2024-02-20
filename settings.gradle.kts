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
    versionCatalogs {
        create("versions") {
            from(files("gradle/versions.versions.toml"))
        }
    }
}

rootProject.name = "IntuitSampleApp"
include(":app")
include(":catdetails")
