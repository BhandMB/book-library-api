# API Pagination Test Plan

Use this plan for endpoints that support paginated collection responses. Skip or adapt cases for endpoints that do not implement pagination.

## Functional cases
- [ ] Default page and page size produce documented behavior.
- [ ] A requested page within range returns the expected records.
- [ ] An empty or out-of-range page returns a stable empty result.
- [ ] Page size limits are enforced to prevent unbounded responses.
- [ ] Sorting is deterministic when multiple records share the primary sort value.
- [ ] Filtering and pagination work together without duplicating or skipping records.

## Input validation
- [ ] Negative page numbers are rejected or normalized according to the API contract.
- [ ] Zero, negative, and excessively large page sizes are handled consistently.
- [ ] Unsupported sort fields and directions are rejected safely.

## Regression checks
- [ ] Response metadata matches the actual number of results and total count.
- [ ] Existing clients remain compatible with the documented response shape.
- [ ] Tests include an empty database and a dataset spanning multiple pages.
- [ ] API documentation contains concrete request and response examples.