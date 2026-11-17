# Book API Integration Test Fixture Strategy

## Goals
Keep integration tests isolated, deterministic, and representative of real persistence behavior.

## Fixture rules
- Create only the records needed by each test.
- Use unique identifiers rather than relying on execution order.
- Clean up data or use an isolated transactional test boundary where appropriate.
- Include realistic relationships and constraint-valid values.
- Avoid shared mutable fixtures across parallel tests.

## Verification
Run tests individually and as a full suite, in a different order, and with parallel execution where supported. Failures should identify the violated behavior rather than depend on hidden test state.