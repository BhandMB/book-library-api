# HTTP Error Contract

The API should return predictable error responses so clients can handle failures consistently.

## Status mapping

- `400 Bad Request`: malformed JSON, invalid field values, or failed validation.
- `404 Not Found`: the requested book or resource identifier does not exist.
- `409 Conflict`: the request violates a uniqueness or state constraint.
- `500 Internal Server Error`: unexpected server failure; do not expose stack traces.

## Response guidance

Return a stable JSON shape with a machine-readable error code, a human-readable message, and a timestamp or correlation identifier when available. Validation responses should identify the affected field without echoing secrets or internal implementation details.

## Client compatibility

Once published, keep field names stable. Add new optional fields rather than changing the meaning of existing fields. Update API examples and integration tests whenever the contract changes.