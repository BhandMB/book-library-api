# API Error Response Guide

Keep error responses predictable so API consumers can handle failures consistently. Adapt the examples to the response format actually implemented by this service.

## Recommended status mapping

| Situation | HTTP status | Notes |
|---|---:|---|
| Malformed request or invalid fields | 400 | Include actionable field-level details when safe |
| Missing or invalid authentication | 401 | Do not disclose credential details |
| Authenticated caller lacks permission | 403 | Keep authorization enforced on the server |
| Requested resource does not exist | 404 | Avoid leaking unrelated resource information |
| Duplicate or conflicting state | 409 | Explain the conflict and recovery path |
| Unexpected server failure | 500 | Return a generic message; log diagnostic details server-side |

## Review checklist
- [ ] Error bodies use a consistent structure.
- [ ] Validation errors identify the relevant field when appropriate.
- [ ] Stack traces and SQL details are not sent to clients.
- [ ] Logs contain a correlation identifier where supported.
- [ ] Tests cover common failures as well as successful requests.
- [ ] README examples match real responses from the current implementation.