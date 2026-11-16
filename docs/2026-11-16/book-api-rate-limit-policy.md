# Book API Rate Limit Policy

## Policy decisions
Document limits by route and caller identity, the time window, burst behavior, and treatment of unauthenticated requests.

## Response contract
Return a consistent rate-limit response and, where supported, retry guidance. Ensure proxy headers are trusted only from configured proxies.

## Verification
Test requests just below, at, and above the limit; parallel requests; separate users; and limit-window reset. Confirm rate limiting does not bypass authorization or block health checks unintentionally.