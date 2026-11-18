# Book API Pagination and Sorting Contract

## Request contract
Use explicit page and size parameters with documented defaults and a maximum page size. Reject negative page values and unsupported sort fields. Define sort direction as asc or desc and use an allowlist of sortable properties.

## Response contract
Return the current page, effective page size, total elements, total pages, and content. Keep the shape stable across empty and populated results.

## Stability
Add a deterministic secondary sort, such as the record identifier, when the requested sort field is not unique. This prevents duplicate or missing items as users move between pages.

## Security and performance
Apply ownership or visibility filters before counting and pagination. Avoid exposing hidden records through total counts. Add indexes for common filter/sort combinations only after reviewing actual query plans.

## Tests
Cover first and last pages, empty results, oversized sizes, unknown sort keys, duplicate sort values, and authorization-scoped totals.