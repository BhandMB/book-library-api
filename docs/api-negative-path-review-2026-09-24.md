# API Negative-Path Review

## Required checks

- Reject malformed identifiers with a stable client error.
- Return a clear not-found response when a book does not exist.
- Validate required fields before persistence.
- Keep error responses free of stack traces and internal implementation details.
- Verify that successful create, update, and delete operations return consistent status codes.

## Regression evidence

Document the request, expected status, and response shape for each negative-path case before release.
