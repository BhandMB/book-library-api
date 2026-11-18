# Book API Validation Error Consistency

## Objective
Give API consumers actionable validation feedback without exposing implementation details.

## Error response
Use a consistent structure containing a stable error code, human-readable message, field-level violations, and a correlation identifier. Do not return stack traces, SQL fragments, class names, or internal file paths.

## Validation principles
- Validate required fields, length limits, numeric ranges, and enum values at the request boundary.
- Normalize whitespace where appropriate, but do not silently transform identifiers.
- Distinguish malformed input from missing resources and authorization failures.
- Avoid returning different errors that reveal whether a protected resource exists.

## Test coverage
Check multiple invalid fields in one request, malformed JSON, unsupported enum values, oversized strings, and validation behavior for create and update operations.

## Client guidance
Clients should use stable error codes for branching and display field messages near the corresponding inputs.