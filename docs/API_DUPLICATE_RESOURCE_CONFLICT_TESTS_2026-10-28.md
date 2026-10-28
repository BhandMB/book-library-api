# API Duplicate Resource Conflict Test Plan

**Date:** 2026-10-28  
**Purpose:** Define expected behavior when a request attempts to create a resource that conflicts with an existing unique value.

## Scenarios

| Scenario | Expected behavior |
|---|---|
| Create a resource with a new unique identifier | Success |
| Create a resource with a duplicate unique identifier | Documented conflict or validation response |
| Two concurrent requests use the same unique identifier | At most one persisted resource |
| Conflict occurs after validation due to a race | Database constraint is handled and mapped to a safe API response |
| Duplicate check uses different letter casing | Behavior follows the database and API's explicit normalization policy |

## Implementation notes

- Keep database uniqueness constraints as the final integrity guard.
- Do not rely only on a pre-insert lookup; concurrent requests can race.
- Map known constraint violations to a stable client response without leaking SQL details.
- Ensure a failed create does not leave related partial records.

## Acceptance criteria

- Integration tests verify status code, response shape, and final record count.
- Concurrent tests use synchronization rather than timing guesses.
- The API contract and OpenAPI documentation describe conflict behavior.