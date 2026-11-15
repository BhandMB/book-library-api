# Book API Schema Migration Policy

## Migration standards
- Keep migrations ordered, immutable after release, and reviewed.
- Prefer additive changes before removing or renaming columns.
- Define defaults and backfill behavior for existing rows.
- Avoid application startup actions that mutate production data unexpectedly.

## Validation
Run migrations against an empty database and a production-like prior schema. Verify constraints, indexes, rollback feasibility, and application compatibility.

Destructive migrations require an explicit backup and recovery plan.