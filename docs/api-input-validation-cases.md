# API Input Validation Cases

Use this matrix when adding or reviewing endpoint validation.

| Area | Invalid input | Expected behavior |
|---|---|---|
| Identifier | Missing or non-positive ID | Return a client error with a stable message |
| Required text | Null, blank, or whitespace-only value | Reject before persistence |
| Length | Value outside documented bounds | Reject and explain the bound |
| Dates | End date before start date | Reject as an inconsistent request |
| Collection | Duplicate item in a unique field | Return a conflict response |

Validation should be consistent across create and update operations, and error responses should avoid leaking stack traces.
