# Database schema migration: expand-contract runbook

## Goal
Deploy schema changes without requiring every application instance to switch versions simultaneously.

## Expand
Add nullable columns, tables, or compatible indexes first. Deploy code that reads old and new representations and, where needed, dual-writes with reconciliation. Avoid destructive renames in the first release.

## Migrate
Backfill in bounded batches. Make the operation restartable and observable. Track processed rows, failures, and duration. Validate counts and invariants before switching reads.

## Contract
After all instances use the new representation and the rollback window passes, remove obsolete columns or compatibility code in a later release.

## Rollback
Prefer rolling back application code while retaining expanded schema. Do not assume destructive migrations are reversible. Document backup/restore prerequisites and approval owner.

## Release checklist
Review lock/runtime impact, test production-like data volume, verify indexes and constraints, monitor errors, and preserve pre/post migration evidence.
