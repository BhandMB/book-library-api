# API Input Validation Checklist

Use this checklist when adding or changing request DTOs and API endpoints.

## Request validation
- [ ] Validate required fields and accepted formats.
- [ ] Define minimum and maximum lengths for user-provided strings.
- [ ] Reject invalid numeric ranges and unsupported enum values.
- [ ] Validate identifiers before using them to retrieve resources.
- [ ] Avoid trusting client-supplied ownership or privilege fields.

## Error behavior
- [ ] Return a documented client-error status for invalid requests.
- [ ] Keep response fields consistent across endpoints.
- [ ] Provide actionable messages without exposing implementation details.
- [ ] Ensure malformed JSON is handled consistently.

## Tests
- [ ] Cover valid requests and boundary values.
- [ ] Cover missing, null, blank, malformed, and oversized values.
- [ ] Confirm rejected requests do not mutate persisted data.
- [ ] Verify the API documentation reflects actual validation behavior.