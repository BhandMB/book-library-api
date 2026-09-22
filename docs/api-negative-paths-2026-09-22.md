# API Negative-Path Matrix — 2026-09-22

Use this matrix when validating controller and service behavior.

| Case | Expected result |
|---|---|
| Missing required field | `400` with field-level validation details |
| Malformed identifier | `400` with a stable error shape |
| Unknown resource | `404` without exposing stack traces |
| Duplicate business value | `409` or documented validation response |
| Unexpected server failure | `500` with a correlation-safe message |

## Acceptance rule
Negative-path tests must verify both the HTTP status and the response contract so clients do not depend on incidental exception text.