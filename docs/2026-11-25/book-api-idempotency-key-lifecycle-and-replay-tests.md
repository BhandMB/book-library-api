# Book Library API Idempotency-Key Lifecycle and Replay Tests

## Purpose
Define safe retry behavior for create or checkout operations that may be repeated after a network timeout.

## Key lifecycle
Scope each idempotency key to the authenticated principal and operation. Store a request fingerprint and the final response or durable outcome. Define expiration and behavior when the same key is reused with a different payload.

## Expected behavior
- Same key and same request returns the original outcome.
- Same key with a different request is rejected.
- Concurrent requests with the same key produce one business operation.
- A retry after a completed operation does not duplicate a loan or book record.
- A failed operation has a documented retry policy.

## Persistence
Persist the key and business result atomically where possible. Add a uniqueness constraint for the idempotency scope. Avoid in-memory-only tracking for operations that must survive restarts.

## Test scenarios
1. Successful request followed by exact replay.
2. Same key with changed title or borrower.
3. Two simultaneous requests with the same key.
4. Server restart before client retry.
5. Validation failure and retry.
6. Key expiration and subsequent reuse.

## API documentation
Explain supported endpoints, key format, retention window, conflict response, and client retry guidance. Do not promise exactly-once network delivery; describe the actual deduplication guarantee.
