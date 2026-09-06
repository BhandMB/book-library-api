# API Observability Checklist — 2026-09-06

Use this checklist before calling the API ready for a demo or deployment.

## Request visibility

- [ ] Logs include request method, route, status, and duration.
- [ ] Sensitive values such as passwords and tokens are excluded.
- [ ] Validation failures are distinguishable from server errors.
- [ ] Correlation or request identifiers are available for troubleshooting.

## Operational signals

- [ ] Health/readiness behavior is documented.
- [ ] Slow endpoints and repeated failures are easy to identify.
- [ ] Database errors are mapped to safe client responses.
- [ ] The README explains how to inspect logs locally.

## Follow-up

Add or update automated tests whenever an observability change affects error handling or response behavior.