# Book Library API Soft Delete and Restore Consistency

## Objective
Document consistency expectations if the service supports soft deletion of books.

## Data model considerations
Represent deletion explicitly with a deletion timestamp or status. Keep the original record identity stable. Ensure normal list and search endpoints exclude deleted records by default.

## Endpoint behavior
- Repeated delete requests should be idempotent or return a documented conflict.
- Restore should be restricted to authorized users.
- Restoring a record must re-check uniqueness constraints and related business rules.
- Public detail endpoints should not reveal deleted records unless explicitly designed to do so.

## Referential integrity
Decide how loans, reservations, reviews, and audit events behave when a book is deleted. Do not cascade-delete historical transactions that must remain auditable.

## Verification
Test deleted-record exclusion from search, direct lookup behavior, unauthorized restore, repeated delete, restore after a conflicting ISBN is created, and preservation of historical references.

## Migration and operations
Backfill existing records with a non-deleted state. Include deleted-record counts in operational diagnostics, but do not expose them in public catalog totals unless documented.

## Implementation caution
Confirm that soft deletion is actually part of the product requirements before introducing schema or endpoint changes.
