# API Database Testing Guide

- Use a dedicated test database or isolated test container.
- Keep test fixtures small, deterministic, and safe to recreate.
- Verify persistence by reading data back after writes.
- Test missing records and uniqueness or relationship constraints where applicable.
- Confirm failed writes leave the database in a consistent state.
- Clean up test data or use transaction rollback where supported.
- Avoid dependence on test execution order.
- Never run destructive tests against production data.
- Keep credentials and connection strings with secrets out of version control.
- Document the test command and required environment variables.