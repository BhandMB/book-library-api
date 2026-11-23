# Book API Pagination Stability and Cursor Design

Date: 2026-11-23

## Objective
Prevent records from being skipped or duplicated when clients page through a changing book catalogue.

## Offset pagination
Document page numbering, default and maximum page sizes, stable ordering, and behavior when records are inserted or deleted between requests.

## Cursor pagination
If cursor pagination is adopted, encode the complete sort position and a unique tie-breaker. Treat cursors as opaque client tokens, validate them, and avoid trusting arbitrary client-supplied SQL sort expressions.

## Consistency choices
State whether pages represent a live view or a consistent snapshot. Explain the trade-off between freshness and repeatability for the expected use case.

## Tests
- [ ] Equal sort values have deterministic ordering.
- [ ] Insertions and deletions have documented effects.
- [ ] Invalid or expired cursors are rejected safely.
- [ ] Maximum page size is enforced.
- [ ] No record duplication occurs within a supported traversal model.

## Scope
Pagination design proposal only; no API behavior was changed.