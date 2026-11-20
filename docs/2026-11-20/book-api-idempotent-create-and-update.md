# Book API: Idempotent Create and Update

Date: 2026-11-20

## Purpose

Define retry-safe behavior for clients that may resend requests after network timeouts.

## Create operations

If the API supports an idempotency key, scope it to the authenticated caller and operation. Persist the key with a request fingerprint and result reference. Reusing a key with a different payload should return a clear conflict rather than silently replaying an unrelated result.

## Update operations

Use resource versions or conditional requests where concurrent edits are possible. A stale update should produce a conflict response that allows the client to reload and reconcile changes.

## Operational rules

- Set a documented retention period for idempotency records.
- Handle concurrent requests using a database uniqueness constraint or equivalent atomic mechanism.
- Do not treat every POST as idempotent by assumption.
- Avoid exposing another caller's stored response.

## Tests

- [ ] Repeated same-key request does not create duplicate records.
- [ ] Same key with a different payload is rejected.
- [ ] Concurrent duplicate requests have one effective result.
- [ ] Stale update is detected.
- [ ] Expired keys follow documented behavior.

## Scope

API design guidance only; no endpoint implementation is claimed.