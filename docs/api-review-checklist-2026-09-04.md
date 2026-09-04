# API Review Checklist — 2026-09-04

Use this checklist before merging API changes:

- Validate request payloads at the boundary.
- Return a consistent error shape for validation and not-found cases.
- Keep controller methods thin and move business rules into services.
- Confirm pagination and sorting defaults are documented.
- Add or update tests for happy path, validation failure, and missing resources.
- Verify database queries avoid accidental N+1 loading.
