# Search query cost and abuse guardrails

## Objective
Keep book search responsive and prevent expensive or malformed requests from degrading the API.

## Input contract
Set limits for query length, page size, filter count, sort fields, and date/range bounds. Normalize whitespace and reject unsupported operators. Parameterize all values; never concatenate user input into SQL.

## Query design
Review indexes against actual filter/sort combinations. Avoid unbounded wildcard scans and N+1 loading. Return only fields required by search results. Establish a timeout and a documented maximum result window.

## Abuse controls
Apply per-principal rate limits where appropriate, bounded concurrency, and safe error responses. Log request IDs and timing metrics without retaining unnecessary search terms or personal data.

## Verification
Use representative data volume to test common and worst-case queries, boundary inputs, repeated expensive requests, and concurrent load. Capture query plans and latency percentiles as evidence.
