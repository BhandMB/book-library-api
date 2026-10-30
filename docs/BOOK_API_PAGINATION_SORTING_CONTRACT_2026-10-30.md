# Book API Pagination and Sorting Contract
Date: 2026-10-30

Document the actual defaults and maximums after inspecting controller behavior. A paginated response should consistently expose content, page index, page size, total elements, and total pages.

Test negative page indexes, zero/negative sizes, oversized sizes, unknown sort properties, unsupported sort directions, empty results, and the final partial page.

Use an allowlist for sortable fields; do not expose internal entity properties. Keep filtering bounded and ensure frequently queried fields are indexed where appropriate.

Add contract tests before changing defaults so frontend compatibility is preserved.

Review plan only; it does not assert current API behavior.