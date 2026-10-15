# OpenAPI Review Checklist

Before releasing API changes, verify that the OpenAPI description matches the implementation.

- [ ] Every public endpoint has a clear summary and description.
- [ ] Path and query parameters specify requiredness and constraints.
- [ ] Request DTOs show required fields and useful examples.
- [ ] Success response schemas match actual JSON output.
- [ ] Common error responses are documented with the shared error format.
- [ ] Pagination, filtering, and sorting behavior is explained where applicable.
- [ ] Authentication requirements are documented if the API uses authentication.
- [ ] Deprecated or removed fields are clearly identified.
- [ ] Examples contain fictional data and no secrets.
- [ ] Generated API docs can be opened in the target environment.

Treat generated documentation as a contract: update it whenever controller signatures, DTOs, validation, or response shapes change.