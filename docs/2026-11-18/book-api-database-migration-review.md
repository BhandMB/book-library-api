# Database Migration Review

## Review goals
Keep schema changes repeatable, reversible where practical, and compatible with deployed application versions during rollout.

## Checklist
- [ ] Migration has a unique, ordered version.
- [ ] Existing data is preserved or a documented transformation is provided.
- [ ] New columns have safe defaults or a staged backfill plan.
- [ ] Index creation and table rewrites are assessed for lock duration.
- [ ] Application compatibility during rolling deployment is considered.
- [ ] Rollback or forward-fix steps are documented.
- [ ] Migration is tested against a representative database snapshot.

## Operational procedure
Take and verify a backup, apply migration in a controlled environment, inspect row counts and constraints, deploy compatible application code, and monitor errors and query latency.

## Evidence
Attach migration output, schema diff, validation queries, and approval. Do not mark a migration safe solely because it succeeds on an empty development database.