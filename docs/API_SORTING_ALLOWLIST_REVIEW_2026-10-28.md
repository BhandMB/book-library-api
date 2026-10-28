# API Sorting Allowlist Review

**Date:** 2026-10-28  
**Purpose:** Reduce invalid queries and keep client-controlled sorting predictable.

## Review checklist

- [ ] Identify every endpoint that accepts a sort field or direction.
- [ ] Define an allowlist of public sort keys rather than passing arbitrary client strings to persistence APIs.
- [ ] Map public names to known entity properties.
- [ ] Validate direction values and define a stable default.
- [ ] Add a deterministic secondary sort key when stable page boundaries matter.
- [ ] Return a clear client error for unsupported sort properties, if that is the chosen contract.
- [ ] Test sorting with filters and pagination combined.
- [ ] Ensure OpenAPI examples match actual defaults and allowed values.

## Test cases

Test ascending and descending order, unknown keys, empty sort values, repeated sort parameters, null values, and equal primary sort values. Avoid tests that depend on unspecified database ordering.

**Status:** Review plan only; implementation and execution must be confirmed separately.