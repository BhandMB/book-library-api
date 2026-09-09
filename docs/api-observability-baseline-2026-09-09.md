# API Observability Baseline

Track these signals before optimizing endpoints:

- Request count by route and HTTP method.
- Latency percentiles for successful and failed requests.
- 4xx and 5xx rates separated by endpoint.
- Database timeout and connection-pool exhaustion events.
- Correlation IDs in logs for multi-step requests.

## Review rule
Every new endpoint should have a documented success response, expected client errors, and a useful log message for unexpected failures without leaking secrets.