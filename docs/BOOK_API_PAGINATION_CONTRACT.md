# Book API Pagination Contract

Use one predictable pagination convention across list endpoints.

## Contract to document in the API
- Whether page indexes start at `0` or `1`.
- The default page size and maximum permitted page size.
- Supported sort fields and sort direction syntax.
- Whether total elements and total pages are returned.
- How invalid page numbers and page sizes are handled.

## Expected behavior
- An empty result set returns an empty collection, not an error.
- Requests beyond the final page return an empty collection with accurate metadata.
- Unsupported sort fields are rejected or safely mapped to an allowlist.
- Page size is capped to protect the service from oversized requests.
- Filtering and pagination must be applied consistently and deterministically.

## Test cases
- [ ] First page with default size.
- [ ] Custom page and size.
- [ ] Empty library.
- [ ] Page beyond the end.
- [ ] Zero or negative page size.
- [ ] Maximum-size enforcement.
- [ ] Sorting with equal field values.
- [ ] Pagination combined with a search/filter.

Keep this contract aligned with the actual controller response and OpenAPI specification.