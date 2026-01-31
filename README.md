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

## Roadmap Progress

This repository is intentionally developed as a **living SDET automation framework**.  
Below is the current progress and planned evolution.

### Phase 1 – Core Web Automation (Completed ✅)
- [x] Java 17 + Maven project setup
- [x] Selenium 4 with WebDriverManager
- [x] TestNG test runner
- [x] Page Object Model (POM) architecture
- [x] Explicit wait utilities
- [x] Positive & negative UI test scenarios
- [x] Screenshot capture on test failure
- [x] Config-driven browser & headless execution
- [x] CI pipeline with GitHub Actions
- [x] Code formatting enforced with Spotless
- [x] Branch-based workflow (main / develop)

### Phase 2 – API Automation (Planned ⏳)
- [ ] REST Assured integration
- [ ] Base API client abstraction
- [ ] Authentication handling (token-based)
- [ ] Positive & negative API test scenarios
- [ ] Schema / contract validation
- [ ] API tests integrated into CI pipeline

### Phase 3 – Advanced SDET Capabilities (Planned ⏳)
- [ ] UI + API end-to-end test flows
- [ ] Parallel test execution
- [ ] Retry mechanism for controlled flaky tests
- [ ] Test tagging (smoke / regression)
- [ ] Dockerized execution (optional)
- [ ] Selenium Grid or remote execution

> The roadmap is continuously updated as the framework evolves.

## Contributing
See `CONTRIBUTING.md` for branching strategy, commit style, and PR guidelines.
