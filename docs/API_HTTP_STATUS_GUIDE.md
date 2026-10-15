# Book Library API HTTP Status Guide

Keep response status codes consistent across controllers and document the actual behavior in OpenAPI.

| Situation | Typical status | Notes |
|---|---:|---|
| Successful read | 200 | Return the requested resource or collection |
| Resource created | 201 | Include a resource location when practical |
| Successful operation with no response body | 204 | Use only when the contract intentionally returns no body |
| Invalid request payload | 400 | Include safe, actionable validation details |
| Unauthenticated request | 401 | Relevant when authentication is enabled |
| Authenticated but forbidden | 403 | Relevant when authorization is enabled |
| Resource does not exist | 404 | Use a consistent error body if the API defines one |
| Conflict with unique/business constraint | 409 | Avoid leaking database internals |
| Unexpected server failure | 500 | Do not expose stack traces to clients |

## Checklist
- [ ] Confirm controller responses match the documented contract.
- [ ] Handle validation exceptions centrally where appropriate.
- [ ] Use a stable error schema for clients.
- [ ] Keep logs detailed enough for diagnosis but free of secrets.
- [ ] Test both successful and failure responses.