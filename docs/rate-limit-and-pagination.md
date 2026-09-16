# Rate Limits and Pagination

## Client expectations
- Treat pagination parameters as untrusted input and apply server-side bounds.
- Keep page numbering and page-size defaults consistent across endpoints.
- Handle an empty page as a valid response when the requested page is beyond the final result.

## Operational guidance
- Document any rate-limit headers exposed by the API.
- Return a stable error shape when limits are exceeded.
- Verify that pagination queries remain deterministic when records share the same sort value.

## Tests
Cover default paging, maximum page size, invalid values, empty pages, and stable ordering across repeated requests.