# OpenAPI Contract Review

## Review checklist
- [ ] Every public endpoint has a summary and meaningful description.
- [ ] Request parameters document required status, format, limits, and defaults.
- [ ] Request and response schemas match actual serialization behavior.
- [ ] Error responses cover validation, authentication, authorization, not-found, and server failures.
- [ ] Authentication requirements are declared consistently.
- [ ] Pagination and sorting semantics are documented.
- [ ] Examples contain synthetic data and no secrets or personal information.
- [ ] Deprecated operations include a migration path.

## Compatibility
Review schema changes for breaking changes before release. Prefer additive changes and version or coordinate unavoidable breaking changes.

## Validation
Generate or inspect the OpenAPI document from a clean application start and compare it with endpoint integration tests. Record known differences rather than assuming generated documentation is accurate.