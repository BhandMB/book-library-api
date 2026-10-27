# API Validation and Error Response Contract

**Date:** 2026-10-27  
**Purpose:** Define consistent client-visible behavior for invalid requests.

## Contract principles

- Validate request data at the API boundary and enforce critical invariants in the service/domain layer too.
- Return a stable error shape; do not expose stack traces, SQL, filesystem paths, or secrets.
- Use appropriate status codes consistently: `400` for malformed/invalid input, `404` for missing resources, `409` for conflicts, and `500` for unexpected failures.
- Include field-level validation messages when safe and useful.
- Keep error messages actionable but avoid leaking whether sensitive records exist.

## Suggested response shape

```json
{
  "timestamp": "2026-10-27T10:00:00Z",
  "status": 400,
  "error": "Bad Request",
  "message": "Request validation failed",
  "path": "/api/books",
  "fieldErrors": [
    { "field": "title", "message": "must not be blank" }
  ]
}
```

This is an example contract; align names and timestamp formatting with the existing API before implementing it.

## Test cases

| Input condition | Expected behavior |
|---|---|
| Missing required title | `400`, field error for title |
| Negative page size | `400` or documented normalization policy |
| Unknown book identifier | `404` |
| Duplicate unique identifier | `409` if conflict is part of the API contract |
| Unexpected server exception | Generic `500`, no internal details |

## Review checklist

- [ ] Error shape is consistent across controllers.
- [ ] Validation errors preserve useful field names.
- [ ] Integration tests assert both status and response body.
- [ ] Logs contain a correlation identifier but no secrets.
- [ ] OpenAPI examples match actual behavior.