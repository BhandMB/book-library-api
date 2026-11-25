# Book Library API Database Constraint and Domain Invariant Review

## Objective
Ensure important catalog and lending rules are protected at the persistence boundary.

## Review areas
- Unique ISBN or other catalog identifier, where applicable
- Required title and ownership fields
- Valid relationships between books, loans, and borrowers
- Non-negative available-copy counts
- Loan due date and return date consistency
- Referential integrity for historical loan records
- Consistent soft-delete or active-state rules, if supported

## Application versus database
Validate inputs in the application for useful error messages, but use database constraints for invariants that must survive concurrent requests and alternate write paths.

## Concurrency checks
Attempt simultaneous checkout of the last available copy. Confirm that only a valid number of loans can be created. Verify transaction rollback if a later write in the workflow fails.

## Migration review
Check existing data for duplicates or invalid values before adding constraints. Provide a cleanup and rollback plan. Avoid destructive schema changes without a verified backup.

## Evidence
Capture migration output, constraint violation handling, integration tests, and reconciliation queries. Translate low-level database errors into stable API error codes without leaking SQL details.
