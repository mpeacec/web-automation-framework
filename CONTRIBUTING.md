# Contributing

## Branch Strategy
- `main`: stable, release-ready
- `develop`: integration branch
- `feature/*`: new work and fixes

## Commit Message Style
Use Conventional Commits:
- `feat:` new feature
- `fix:` bug fix
- `docs:` documentation
- `test:` test changes
- `chore:` tooling or maintenance

## Pull Request Checklist
- Tests pass locally (`mvn clean test`)
- Spotless check passes (`mvn spotless:check`)
- Screenshots updated or referenced if UI changes
- Documentation updated if behavior or usage changed
