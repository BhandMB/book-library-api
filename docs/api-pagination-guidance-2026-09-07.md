# API Pagination Guidance — 2026-09-07

## Contract expectations

- Keep page number and page size validation explicit.
- Return stable ordering so clients do not see duplicate or missing records between pages.
- Include total elements and total pages when the endpoint supports metadata.
- Document the default page size and the maximum accepted page size.

## Verification cases

1. First page with the default size.
2. Page beyond the last page.
3. Zero or negative page values.
4. Oversized page requests.
5. Stable ordering when records share the same primary sort value.