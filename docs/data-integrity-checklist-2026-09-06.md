# Data Integrity Checklist — 2026-09-06

Before releasing changes that write library data, verify:

- [ ] Required fields are validated at the API boundary.
- [ ] Duplicate identifiers are rejected consistently.
- [ ] Update operations preserve immutable fields.
- [ ] Delete behavior is explicit and documented.
- [ ] Failed writes do not leave partial state behind.
- [ ] Tests cover empty, boundary, and duplicate-input cases.

When a rule changes, update the API documentation and the corresponding automated test in the same change.