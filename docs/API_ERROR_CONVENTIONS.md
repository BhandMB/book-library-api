# API Error Conventions

Keep error responses consistent across endpoints.

- Use 400 for malformed requests or failed input validation.
- Use 401 when authentication is required but missing or invalid.
- Use 403 when an authenticated caller lacks permission.
- Use 404 when the requested resource does not exist.
- Use 409 for a documented resource conflict, such as a duplicate unique value.
- Use 500 only for unexpected server failures; do not expose stack traces or database internals.
- Include a clear message and field-level validation details where appropriate.
- Add tests for status codes and response shape when error handling changes.

These are project conventions to adopt consistently; confirm actual endpoint behavior before documenting it as implemented.
