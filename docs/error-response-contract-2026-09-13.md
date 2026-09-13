# Error Response Contract

Every API error should expose:

- a stable HTTP status
- a machine-readable error code
- a human-readable message
- the request path
- a timestamp or trace identifier when available

Clients should rely on the code, not on message text, for branching behavior.
