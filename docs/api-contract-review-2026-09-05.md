# API Contract Review — September 5, 2026

## Contract checks

- Use consistent HTTP status codes for success, validation, not-found, and server-error paths.
- Keep request and response JSON field names stable and documented.
- Return validation errors in a predictable structure so clients can handle them safely.
- Confirm pagination parameters have clear defaults and maximum limits.
- Verify API examples match the current controller and DTO behavior.

## Release gate

Before publishing a change, run the test suite and manually exercise one happy path, one validation failure, and one not-found case.