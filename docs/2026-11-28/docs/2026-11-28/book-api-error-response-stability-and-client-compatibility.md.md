# Error response stability and client compatibility

## Contract
Clients should be able to handle API errors without parsing implementation-specific exception messages.

## Response shape
Define stable fields such as machine-readable code, safe message, correlation ID, and optional field-level validation details. Keep stack traces, SQL, internal hostnames, and secrets out of responses.

## Compatibility rules
- Do not change an existing error code's meaning silently.
- Add optional fields in a backward-compatible manner.
- Document status-code changes and retryability.
- Distinguish validation, authentication, authorization, not-found, conflict, rate-limit, and server failures.
- Return consistent content types for error responses.

## Tests
Contract-test each error category, malformed JSON, unsupported media type, expired authentication, forbidden object access, conflict, and unexpected server exception. Verify clients can rely on codes while display text remains safe to evolve.
