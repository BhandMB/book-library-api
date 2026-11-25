# Book Library API Observability and Correlation Guidance

## Purpose
Make production failures traceable across HTTP requests, service operations, and database calls.

## Correlation
Accept or generate a request correlation ID. Return it in response headers and include it in structured logs. Validate incoming IDs for length and safe characters to prevent log injection.

## Logging
Prefer structured fields such as timestamp, severity, route template, status code, duration, and correlation ID. Do not log authorization headers, passwords, tokens, or full personal payloads.

## Metrics
Useful signals include request rate, error rate, latency percentiles, database pool saturation, and failed background jobs. Label metrics with bounded values; avoid user IDs and raw request paths as metric labels.

## Error budget
Define service objectives with stakeholders before setting alert thresholds. Use burn-rate alerts for sustained reliability degradation rather than alerting on every isolated error.

## Diagnostic workflow
1. Identify the affected route and time window.
2. Follow the correlation ID across logs.
3. Check dependency and database health.
4. Compare current metrics with the baseline.
5. Record impact, mitigation, and follow-up action.

## Verification
Confirm correlation IDs are present on success and error responses, and that logs remain useful without exposing secrets.
