# Book Library API Smoke Tests

Run these checks after starting the API and before publishing a build.

| Check | Expected result |
|---|---|
| Health or root endpoint | Returns a successful response |
| List books | Returns a valid JSON collection |
| Create book with required fields | Returns a created resource and identifier |
| Fetch created book | Returns the same resource |
| Update book | Returns updated values |
| Delete book | Returns the documented success response |
| Fetch deleted book | Returns the documented not-found response |
| Missing required field | Returns a client-error response with useful details |
| Malformed identifier | Returns a client-error response without a server stack trace |

## Repeatability

Use a disposable test record and clean it up after the run. Keep the request payloads versioned with the project so regressions can be reproduced consistently.
