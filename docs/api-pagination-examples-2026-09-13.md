# API Pagination Examples

## Expected behavior
- Default page size is documented and bounded.
- Page indexes are validated before querying.
- Responses include total elements and total pages.
- Empty pages return a stable response shape.

## Verification
Test first page, middle page, last page, oversized page, and an empty result set.
