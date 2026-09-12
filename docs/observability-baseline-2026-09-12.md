# Observability Baseline

## Signals to capture
- Request count by endpoint and HTTP method
- Response latency percentiles for read and write operations
- 4xx and 5xx error counts
- Database connectivity and migration status

## Review questions
- Are logs free of credentials and tokens?
- Can a failed request be correlated with a request identifier?
- Are health checks separated from business metrics?
