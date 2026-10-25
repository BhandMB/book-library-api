# API CRUD lifecycle test matrix

Date: 2026-10-25

Create: valid payload, required fields, duplicates. Read: existing/missing ID and empty/populated list. Update: intended fields, invalid update preserves state, conflicts. Delete: existing resource, repeated deletion, subsequent reads. Across all tests verify contract, authorization, persistence, and test-data cleanup.
