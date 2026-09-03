# Backend Review — September 3, 2026

Use this checklist when reviewing changes to the Book Library REST API.

## API boundary
- [ ] Request payloads are validated.
- [ ] Response contracts do not expose persistence implementation details.
- [ ] HTTP status codes match the operation result.

## Business logic
- [ ] Business rules remain in the service layer.
- [ ] Missing resources and duplicate ISBN cases are handled consistently.
- [ ] Pagination and sorting inputs remain constrained to supported values.

## Quality
- [ ] Success and failure paths have automated coverage.
- [ ] OpenAPI documentation matches the implemented endpoints.
- [ ] `mvn test` passes before pushing.
- [ ] No credentials or secrets are committed.
