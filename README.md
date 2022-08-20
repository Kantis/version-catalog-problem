# version-catalog-problem

Reproduce:

```bash
cd version-catalog
./gradlew publishKotestVersionCatalogPublicationToMavenLocal
cd ../use-shared-catalog
./gradlew build

> Method org/gradle/accessors/dm/LibrariesForKotest_Decorated.getExtensions()Lorg/gradle/api/plugins/ExtensionContainer; is abstract
```
