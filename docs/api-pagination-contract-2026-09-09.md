# API Pagination Contract

## Response expectations
- Requests define page number and page size explicitly.
- Responses return stable ordering so clients can safely move between pages.
- Metadata should expose total elements and total pages when the backing store can provide them.

## Validation cases
- Reject zero or negative page sizes.
- Apply a documented maximum page size.
- Return an empty content list for a valid page beyond the final page.
- Keep the default sort deterministic.

## Compatibility note
Document parameter names and defaults in the API examples before changing them so existing clients can migrate safely.