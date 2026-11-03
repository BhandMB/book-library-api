# Book Library API Input Validation Contract

Date: 2026-11-03

## Create and update requests
- Require a non-blank title and validate maximum lengths.
- Validate author and category fields against documented limits.
- Validate publication year using an agreed business range; do not silently rewrite invalid values.
- Reject malformed identifiers and unsupported content types.
- Treat optional fields consistently: omitted, null, and empty string should have documented semantics.

## Error response expectations
Return a stable response shape containing a machine-readable error code, a safe human-readable message, and field errors when applicable. Do not return stack traces or persistence-layer exception text.

## API behavior
- Invalid input must not create or partially update a book.
- Update requests must distinguish not-found resources from validation failures.
- Responses should use appropriate 4xx status codes.
- Add tests for boundary values, whitespace-only strings, malformed JSON, and oversized values.

This contract is a proposed quality baseline. Confirm it against the current DTOs and controllers before treating it as implemented.