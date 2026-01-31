![CI](https://github.com/mpeacec/web-automation-framework/actions/workflows/tests.yml/badge.svg?branch=main)
# SDET Automation Framework

## Vision
A long-lived, production-lean automation framework that balances reliability, clarity, and maintainability. Designed for SDETs who need repeatable UI checks, clean architecture, and actionable diagnostics without overengineering.

## Features
- Page Object Model (POM) structure with explicit waits
- Config-driven execution (browser, headless)
- Failure screenshots via TestNG listener
- Maven + TestNG test runner
- CI via GitHub Actions
- Lightweight formatting gate (Spotless)

## Tech Stack
- Java 17
- Maven
- Selenium 4
- TestNG
- WebDriverManager
- GitHub Actions

## Quick Start
```bash
mvn clean test
```

## Configuration
Edit `src/test/resources/config.properties`:
```properties
baseUrl=https://the-internet.herokuapp.com
browser=chrome
headless=false
```

## Running Tests
- All tests:
```bash
mvn clean test
```
- Smoke tests only:
```bash
mvn clean test -Dgroups=smoke
```
- Failure demo (screenshot validation):
```bash
mvn test -DfailureDemo=true
```

## Reporting
- Surefire reports: `target/surefire-reports`
- Failure screenshots: `target/screenshots`

## CI
GitHub Actions workflow runs on push/PR to `main` and `develop`:
- `spotless:check`
- `mvn clean test`
- Uploads Surefire reports and screenshots as artifacts

## Roadmap
See `ROADMAP.md` for planned phases across UI, API, and mobile automation.

## Contributing
See `CONTRIBUTING.md` for branching strategy, commit style, and PR guidelines.
