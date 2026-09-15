# API Security Review Baseline

Use this checklist before exposing the book-library API beyond local development.

## Request handling
- Validate required fields and reject malformed payloads with the documented error contract.
- Keep server-side validation independent of client-side validation.
- Avoid returning stack traces, database details, or internal implementation names in error responses.

## Authentication and authorization
- Protect write operations explicitly rather than relying on the client to hide controls.
- Verify authorization for the requested resource, not only the presence of a valid session/token.
- Keep credentials and tokens out of source control and logs.

## Data and operations
- Use parameterized persistence operations.
- Apply sensible request-size and pagination limits.
- Log security-relevant failures without recording secrets.

## Verification
For every security-sensitive endpoint, test the happy path, malformed input, missing authentication, insufficient authorization, and nonexistent-resource cases.
