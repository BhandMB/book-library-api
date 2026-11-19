# API Rate-Limit Response Contract

## Goals
Protect service availability while giving clients a predictable recovery path.

## Contract
When a client exceeds its applicable limit, return the documented rate-limit status and a stable error code. Include retry guidance such as a retry-after value when the server can calculate it.

## Policy dimensions
- Define limits by authenticated identity, API key, or network origin according to the threat model.
- Apply stricter controls to expensive search or authentication endpoints where appropriate.
- Avoid treating shared network addresses as perfect user identity.
- Ensure trusted internal health checks have a deliberate policy.
- Document whether limits are fixed-window, sliding-window, or token-bucket based.

## Client behavior
Clients should back off rather than retrying immediately in a tight loop. Respect server retry guidance and preserve safe idempotency behavior for retried writes.

## Tests
Verify limit boundaries, reset behavior, concurrent requests, missing identity, and response headers. Confirm that rate-limit storage failure has a defined fail-safe behavior.