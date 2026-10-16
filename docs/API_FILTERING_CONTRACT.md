# Book Library API Filtering Contract

Document supported filters explicitly so clients can rely on stable behavior.

## Contract decisions
- List the supported query parameters and accepted values.
- Define whether matching is exact, case-insensitive, or partial for each field.
- Specify how whitespace and empty query values are handled.
- Define whether multiple filters combine with AND or OR semantics.
- Clarify how filtering interacts with sorting and pagination.
- Reject or safely ignore unsupported parameters according to the API contract.

## Quality checks
- [ ] No filter returns the normal collection response.
- [ ] A matching filter returns expected records.
- [ ] A filter with no matches returns an empty collection.
- [ ] Case and whitespace behavior is tested where relevant.
- [ ] Multiple filters produce deterministic results.
- [ ] Pagination metadata reflects filtered results.
- [ ] Inputs cannot trigger unbounded or unsafe query behavior.

Keep this document aligned with controller parameters, repository queries, tests, and OpenAPI.