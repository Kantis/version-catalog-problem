plugins {
   `version-catalog`
   `maven-publish`
}

catalog {
   val groupId = "io.kotest"
   val publishVersion = "5.4.2"
   val extensionsGroupId = "$groupId.extensions"

   println("using groupId: $groupId and version: $publishVersion for version catalog")

   versionCatalog {
      listOf(
         "assertions-api",
         "assertions-core",
         "assertions-json",
         "assertions-shared",
         "assertions-sql",
         "framework-api",
         "framework-concurrency",
         "framework-datatest",
         "framework-discovery",
         "framework-engine",
         "property",
         "runner-junit4",
         "runner-junit5",
         "extensions-htmlreporter", // Extension built and released with main kotest project
         "extensions-junitxml" // Extension built and released with main kotest project
      ).forEach { alias ->
         library(alias, groupId, "kotest-$alias").version(publishVersion)
      }

      // Extensions
      listOf(
         "spring" to "1.1.2",
         "koin" to "1.1.0",
         "testcontainers" to "1.3.4",
         "wiremock" to "1.0.3",
         "mockserver" to "1.2.1",
         "robolectric" to "0.5.0",
         "allure" to "1.2.0"
      ).forEach { (extension, version) ->
         library("extensions-$extension", extensionsGroupId, "kotest-extensions-$extension").version(version)
      }

      // Assertion extensions
      listOf(
         "arrow" to "1.2.5",
         "ktor" to "1.0.3"
      ).forEach { (extension, version) ->
         library("assertions-$extension", extensionsGroupId, "kotest-assertions-$extension").version(version)
      }
   }
}

publishing {
   publications {
      create<MavenPublication>("KotestVersionCatalog") {
         from(components["versionCatalog"])
         groupId = "emil"
         artifactId = "kotest-version-catalog"
         version = "5.4.2"
      }
   }
}
