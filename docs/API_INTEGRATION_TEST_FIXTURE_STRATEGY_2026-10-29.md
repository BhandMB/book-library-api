# API Integration Test Fixture Strategy

**Date:** 2026-10-29  
**Purpose:** Make API integration tests deterministic, isolated, and maintainable.

## Fixture principles

- Give each test explicit ownership of the records it creates.
- Prefer a disposable test database or isolated schema over shared developer data.
- Avoid relying on auto-generated IDs or implicit database row order.
- Use builders or fixture helpers for valid default objects, then override one field for negative cases.
- Keep test credentials and sample data synthetic.
- Clean up state safely, or use transaction rollback when compatible with the test architecture.

## Coverage layers

1. **Controller/API tests:** status codes, serialization, validation, and error contract.
2. **Service tests:** business rules and conflict behavior.
3. **Persistence tests:** mappings, constraints, and query behavior.
4. **End-to-end checks:** critical request flows across the configured stack.

## Reliability checklist

- [ ] Tests pass independently and in a different execution order.
- [ ] No test depends on a developer's local database state.
- [ ] Time-sensitive assertions use a controllable clock where practical.
- [ ] Concurrent tests coordinate explicitly rather than sleeping for a guessed duration.
- [ ] CI uses the same documented commands and supported runtime versions.
- [ ] Failed tests provide enough context without logging secrets.