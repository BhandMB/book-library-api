# Book API idempotency key contract

## Scope
Use idempotency where retries could create harmful duplicate side effects; do not apply it indiscriminately to reads.

## Request contract
- Client supplies a high-entropy key scoped to authenticated principal and operation.
- Server stores key, request fingerprint, processing state, response status/body reference, and expiry.
- Same key and same semantic request returns the original outcome.
- Same key with a different fingerprint returns conflict.
- Concurrent requests for one key are serialized by a database uniqueness constraint.

## State model
Use IN_PROGRESS to prevent duplicate execution and COMPLETED to replay the stored outcome. Define safe retry rules for failures and crashes between side effect and response persistence.

## Security and retention
Prevent cross-user replay. Avoid storing sensitive request bodies unnecessarily. Set retention longer than the expected retry window and document expiry behavior.

## Tests
Sequential duplicate, concurrent duplicate, changed payload, expired key, unauthorized replay, and recovery after simulated interruption.
