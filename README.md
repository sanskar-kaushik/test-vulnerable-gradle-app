# SecAgent AI — vulnerable Gradle demo

Single-project Gradle (Groovy DSL) application for testing dependency security remediation.

**Intentionally vulnerable. For local/CI testing only. Do not deploy or expose.**

The initial dependencies include Apache Commons Text 1.9 and Log4j Core 2.14.1.
Both are intentionally outdated to test automated upgrades.

## Generate a Gradle wrapper

Use JDK 17 and a locally installed Gradle executable to generate the wrapper:

```sh
gradle wrapper --gradle-version 8.14.3 --distribution-type bin
./gradlew --version
./gradlew clean build
./gradlew dependencies --configuration runtimeClasspath
```

Commit the generated `gradlew`, `gradlew.bat` and `gradle/wrapper/` files,
including `gradle-wrapper.jar`, to GitHub. This lets SecAgent use exactly
the same Gradle release on both macOS and GitHub Actions.

The project contains a real JUnit test, not a placeholder echo build.
The first Gradle download can take a little time.

## SecAgent testing

1. Push this project to the `main` branch of `test-vulnerable-gradle-app`.
2. Add the repository to `SECURITY_REPOSITORIES` in `security-agent`.
3. Run `pnpm run scan` locally, confirm detection and vulnerability count.
4. Test remediation with Gradle as the only configured GitHub Actions target.
5. Review and test the pull request before merging.

No NVD key is required for the configured OWASP data-feed fallback,
although database availability and caching still affect scan times.
