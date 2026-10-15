# Book Library API Integration Test Checklist

Integration tests should verify externally observable API behavior, including persistence and error handling.

## Resource operations
- [ ] Create a valid book and verify the returned representation.
- [ ] Retrieve a known book by ID.
- [ ] List books and verify collection metadata if provided.
- [ ] Update an existing book and confirm persisted values.
- [ ] Delete a book and verify subsequent retrieval behavior.

## Negative cases
- [ ] Submit malformed JSON or invalid field values.
- [ ] Request a nonexistent resource.
- [ ] Exercise duplicate values constrained by the data model.
- [ ] Send invalid identifiers and boundary values.
- [ ] Verify database failures do not leak implementation details.

## Test isolation
- Use a predictable test database or isolated test configuration.
- Avoid relying on records created by a different test.
- Clean up state or use transactional isolation where suitable.
- Assert status code, response body, and important persistence effects.
- Keep fixtures representative but small.

Run integration tests in CI where supported and document any environment prerequisites.