# API Release Verification Checklist

## Before release
- [ ] Review changes and dependency updates.
- [ ] Run the project's documented build and test commands.
- [ ] Check API request and response compatibility.
- [ ] Verify authentication and authorization for changed routes.
- [ ] Confirm configuration and secrets are supplied safely through the environment.

## Persistence and operations
- [ ] Review database migration and rollback expectations.
- [ ] Confirm logs avoid credentials and sensitive payloads.
- [ ] Check health and startup behavior in the target environment.
- [ ] Confirm error responses are safe and consistent.

## Release record
- Version/commit: 
- Test command and result: 
- Known limitations: 
- Reviewer/date: 

Do not mark checks complete until they have been performed.