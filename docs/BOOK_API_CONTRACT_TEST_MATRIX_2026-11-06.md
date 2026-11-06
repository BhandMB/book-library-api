# Book Library API REST Contract Test Matrix

Date: 2026-11-06

## Resource collection
- List request returns the documented collection envelope.
- Pagination and sorting parameters are validated.
- Empty collections return a consistent successful response.
- Unsupported sort fields are rejected or safely ignored according to the contract.

## Individual resource
- Existing ID returns the documented representation.
- Unknown ID returns the documented not-found response.
- Create returns the documented status and resource location when applicable.
- Update changes only permitted fields.
- Delete behavior is consistent and repeatable according to the API contract.

## Cross-cutting
Check content types, validation errors, authentication requirements, and safe error bodies. Assert status, headers, and JSON structure rather than only checking that a request does not throw.

Run against the actual application and record results separately; this matrix is not evidence of passing tests.