# Book Library API Observability Runbook

Date: 2026-11-03

## First-response triage
1. Record the time window, environment, endpoint, and correlation/request ID.
2. Check application health and database connectivity.
3. Compare error rate and latency with the normal baseline.
4. Inspect sanitized logs for the failing request path.
5. Determine whether the issue is isolated to one endpoint or affects all requests.

## Safe logging
Log request identifiers, route templates, status codes, and durations. Do not log passwords, authorization headers, access tokens, or full personal records.

## Recovery
- Roll back only when a recent release is strongly correlated with the incident.
- Restore database backups only under an approved recovery procedure.
- Verify read and write paths after recovery.
- Record root cause, customer impact, corrective action, and regression coverage.

## Operational note
Add metrics and alerts only after confirming the application's actual monitoring stack. This runbook is a proposed operating procedure, not evidence of configured monitoring.