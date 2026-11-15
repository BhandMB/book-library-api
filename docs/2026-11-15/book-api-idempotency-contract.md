# Book API Idempotency Contract

Identify write operations where client retries could create duplicate records or repeat side effects.

## Contract
For supported operations, define the idempotency-key format, retention period, request fingerprint, and behavior when a key is reused with a different payload.

## Verification
Test first submission, identical retry, concurrent duplicate submissions, expired keys, and key reuse with changed content.

Persist the outcome atomically with the operation. Document endpoints that do not support idempotency.