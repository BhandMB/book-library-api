# Book API Integration Test Data Isolation

Date: 2026-11-22

## Goal
Make integration tests repeatable and independent of execution order.

## Data strategy
Use explicit fixtures with unique identifiers. Keep test setup close to the scenario and avoid depending on developer-local database contents. Define whether each test uses rollback transactions, isolated schemas, or disposable containers.

## Isolation concerns
- Parallel tests must not share mutable records unintentionally.
- Tests should not depend on generated IDs being a fixed value.
- External services should be replaced with deterministic test doubles where appropriate.
- Cleanup must not remove data owned by another test.
- Time-dependent tests should use a controllable clock.

## Verification
- [ ] Tests pass individually and as a suite.
- [ ] Repeated runs produce the same outcomes.
- [ ] Parallel execution does not cause cross-test contamination.
- [ ] Failure output identifies the fixture and scenario.
- [ ] No production credentials or data are used.

## Scope
Test infrastructure guidance only; no test suite was executed.