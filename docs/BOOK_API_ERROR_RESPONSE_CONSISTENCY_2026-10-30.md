# Book API Error Response Consistency
Date: 2026-10-30

Goal: predictable client errors for validation, authentication, authorization, missing resources, conflicts, and unexpected failures.

Suggested response fields: timestamp, status, stable error category, safe message, request path, and optional fieldErrors.

Expected mappings to verify: 400 invalid input; 401 unauthenticated; 403 forbidden; 404 missing resource; 409 duplicate/conflict; 500 unexpected failure.

Never expose stack traces, SQL details, secrets, or internal class names. Preserve correlation IDs in server logs. Test every exception mapping and assert sensitive details are absent.

Design/review document only; implementation is not claimed.