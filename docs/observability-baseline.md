# Observability Baseline

For each request path, capture enough information to diagnose failures without logging secrets:

- request method and route
- response status
- elapsed time
- correlation or request identifier when available
- validation and persistence failures at an appropriate log level

Do not log passwords, tokens, or full sensitive payloads.
