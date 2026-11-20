# Book API Error Response Taxonomy

Date: 2026-11-20

## Objective

Provide clients with stable, actionable error responses without leaking implementation details.

## Suggested categories

- Validation failure: request fields are malformed or outside allowed limits.
- Authentication required: caller identity is missing or invalid.
- Forbidden: caller is authenticated but lacks permission.
- Not found: requested resource is unavailable within the caller's permitted scope.
- Conflict: operation violates a uniqueness or concurrency rule.
- Rate limited: caller exceeded a documented request threshold.
- Internal failure: unexpected server error with a correlation identifier.

## Response guidance

Use a consistent machine-readable code, safe message, optional field errors, and correlation ID. Do not return stack traces, SQL text, filesystem paths, secrets, or raw exception messages.

## Client guidance

Clients should display safe messages, preserve form input where appropriate, and retry only errors documented as transient. Avoid retry loops for validation, forbidden, or conflict responses.

## Checklist

- [ ] Status codes and error codes are documented.
- [ ] Field errors identify safe field names.
- [ ] Internal details remain server-side.
- [ ] Correlation IDs connect client reports to logs.
- [ ] OpenAPI examples match actual responses.

## Scope

Taxonomy guidance only; runtime responses have not been inspected or changed.