# API Contract Compatibility Checklist

Before changing a public API response or request:

- [ ] Identify clients that depend on the current contract.
- [ ] Review field names, types, nullability, and required properties.
- [ ] Check status codes and error response structure.
- [ ] Review pagination and sorting semantics.
- [ ] Consider how unknown or newly added fields are handled.
- [ ] Update API documentation and examples.
- [ ] Add regression tests for existing behavior.
- [ ] Prefer additive changes when backward compatibility is required.
- [ ] Document breaking changes and migration guidance.

Confirm behavior against the API implementation before publishing this checklist as release evidence.