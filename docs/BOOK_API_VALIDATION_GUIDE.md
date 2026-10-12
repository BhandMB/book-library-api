# Book API Validation Guide

## Input validation
Validate request payloads at the API boundary and keep business rules in the service layer.

Potential book fields to validate according to the existing model:
- Title: required and not blank.
- Author: required and not blank.
- ISBN: normalize whitespace and enforce the format/uniqueness rule used by this project.
- Publication year: reject values outside the domain's accepted range.
- Identifiers: validate path identifiers and return a consistent not-found response.

Do not introduce a rule that conflicts with existing product requirements; confirm model fields and database constraints before implementation.

## Error response consistency
- Return field-level details for invalid request bodies when practical.
- Avoid returning stack traces or database internals to clients.
- Use the same error structure across validation, missing-resource, and conflict responses.
- Keep status codes meaningful and document them in OpenAPI.

## Tests
- [ ] Missing required fields.
- [ ] Blank strings and boundary lengths.
- [ ] Malformed identifiers.
- [ ] Duplicate ISBN or other unique fields.
- [ ] Nonexistent book ID.
- [ ] Valid request remains accepted.

Update this guide whenever request DTOs or validation constraints change.