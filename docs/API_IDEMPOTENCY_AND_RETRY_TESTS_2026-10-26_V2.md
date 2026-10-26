# API idempotency and retry tests

Date: 2026-10-26

Identify operations that may be retried by clients. Test repeated requests, timeout-and-retry scenarios, duplicate creation risks, and safe handling of conflicting updates. Where idempotency keys are supported, verify key reuse and payload mismatch behavior. Document expected semantics before treating any behavior as guaranteed.
