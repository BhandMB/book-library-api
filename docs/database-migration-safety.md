# Database Migration Safety

Use this checklist for schema changes in the book-library API.

## Before changing the schema
- Confirm the migration is backward-compatible with the deployed application.
- Identify indexes, constraints, and data conversions that may affect existing rows.
- Test the migration against a representative local dataset.

## During rollout
- Keep destructive operations separate from additive changes.
- Record the expected rollback or recovery path.
- Monitor startup and persistence errors after applying the change.

## Verification
Run application startup, repository tests, and representative read/write requests before considering the migration complete.