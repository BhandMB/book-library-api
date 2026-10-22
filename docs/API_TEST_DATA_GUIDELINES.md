# API Test Data Guidelines

- Use a dedicated local or CI test database; never run destructive tests against production.
- Make test data deterministic and independent of execution order.
- Give each test unique identifiers where uniqueness constraints apply.
- Clean up created records or use transaction rollback when supported by the test setup.
- Include valid, invalid, boundary, and missing-value examples.
- Avoid real personal information, access tokens, and production credentials.
- Keep fixtures small and readable; document why special cases exist.
- Ensure tests can run repeatedly without manual database repair.
- Record environment assumptions and the exact command used to run the suite.