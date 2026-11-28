# Conditional update and ETag contract

## Purpose
Reduce lost updates when multiple clients edit the same book resource.

## HTTP contract
- Return an entity tag with a representation when conditional updates are supported.
- Require the client to send the previously observed validator for updates.
- Return a precondition failure when the resource has changed since it was read.
- Return a precondition-required response when the API mandates conditional writes and the client omits the validator.
- Advance the validator after a successful mutation.

## Implementation notes
Base the validator on a reliable version or representation hash. Ensure database concurrency control backs the HTTP contract; a header check alone is insufficient. Define behavior for deletes and representation changes.

## Tests
Cover matching validator, stale validator, missing validator, concurrent updates, delete race, and unchanged representation. Confirm stale writes do not modify persisted fields.
