dependencyResolutionManagement {
    repositories {
        mavenLocal()
    }
    versionCatalogs {
        create("kotest") {
            from("emil:kotest-version-catalog:5.4.2")
        }
    }
}

