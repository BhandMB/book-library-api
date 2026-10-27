# API Pagination Boundary Test Plan

**Date:** 2026-10-27  
**Purpose:** Specify boundary behavior for paginated collection endpoints.

## Boundary scenarios

| Scenario | Expected behavior to lock down |
|---|---|
| First page with records | Returns at most the requested page size and correct metadata |
| Page beyond the final page | Empty content with valid metadata, or the documented alternative |
| Page size at minimum | One record maximum when records exist |
| Page size above maximum | Reject or cap according to an explicit policy |
| Zero or negative page index | Reject or normalize according to the API contract |
| Empty collection | Empty content and zero total elements/pages as appropriate |
| Sort by unsupported property | Validation error rather than an uncontrolled server error |
| Equal sort values | Add a deterministic tie-breaker if stable page boundaries are required |

## Consistency checks

1. Create more records than fit on one page.
2. Fetch adjacent pages and verify there are no duplicate IDs under a stable dataset.
3. Verify total counts reflect the same filters as page content.
4. Repeat with search filters and sorting enabled together.
5. Document that offset pagination can shift during concurrent inserts/deletes.

## Acceptance criteria

- Maximum page size is explicit and tested.
- Sorting fields are allow-listed where user-controlled sorting is supported.
- Response metadata is consistent across collection endpoints.
- Tests do not rely on unspecified database row order.