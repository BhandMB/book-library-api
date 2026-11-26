# Book Library API Pagination Consistency Under Concurrent Writes

## Objective
Specify expected pagination behavior when catalog records are added, removed, or updated while a client is browsing.

## Offset pagination
Document that offset-based pages can shift when records are inserted or deleted before the current offset. Use deterministic sorting with a unique tie-breaker to reduce unstable ordering.

## Cursor pagination
For large or frequently changing collections, consider a cursor based on the complete sort key. Validate cursor integrity and bind it to the relevant filter and sort parameters so it cannot be reused with a different query unexpectedly.

## Contract decisions
Define whether total counts are snapshots or live values. Document how deleted records and changed sort keys affect subsequent pages. Do not promise a consistent snapshot unless the backend actually provides one.

## Test scenarios
- Insert a record between page requests.
- Delete a record before the current offset.
- Update a record's sort key.
- Equal sort values across page boundaries.
- Reuse cursor with different filters.
- Malformed or tampered cursor.

## Acceptance criteria
Clients receive deterministic ordering for a fixed dataset, and documented behavior for concurrent changes matches actual database semantics.
