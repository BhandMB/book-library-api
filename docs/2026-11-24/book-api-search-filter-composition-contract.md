# Book Library API Search and Filter Composition Contract

## Purpose
Make search behavior predictable when clients combine text search, category filters, availability, and sorting.

## Query semantics
- Define whether text matching is case-insensitive and which fields are searched.
- Treat omitted filters as unrestricted; reject malformed filter values.
- Combine independent filters with AND unless the API explicitly documents otherwise.
- Define whether multiple values within one filter use OR semantics.
- Normalize leading/trailing whitespace and impose a maximum query length.

## Sorting and pagination
Use a stable secondary sort key, such as the immutable book ID, so equal primary sort values do not cause records to jump between pages. Validate page size and sort fields against an allowlist. Return total count only if the cost is acceptable and the response contract promises it.

## Security and performance
Use parameterized queries. Avoid building raw SQL from user-supplied sort or filter names. Add indexes based on measured query plans rather than speculative indexing.

## Test matrix
- Search alone
- Each filter alone
- Search plus one filter
- Multiple filters together
- Empty and whitespace-only search
- Unknown category
- Unsupported sort field
- Stable ordering across repeated page reads
- Large page-size rejection

## Documentation
OpenAPI examples should show combined filters and explain the matching semantics. Keep frontend and backend defaults aligned.
