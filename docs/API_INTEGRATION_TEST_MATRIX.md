# API Integration Test Matrix

Use this matrix to plan HTTP-level tests for implemented API routes.

| Area | Success case | Failure case |
|---|---|---|
| Resource listing | Returns expected collection | Handles invalid query parameters |
| Resource detail | Returns an existing resource | Returns documented not-found response |
| Resource creation | Valid payload persists | Invalid payload is rejected |
| Resource update | Valid change is persisted | Missing resource or invalid change is handled |
| Resource deletion | Authorized deletion follows contract | Missing resource or disallowed action is handled |
| Validation | Boundary-valid input is accepted | Malformed and out-of-range input is rejected |

## Test quality checklist
- [ ] Use the configured test application context where practical.
- [ ] Verify status code, response body, and persisted state.
- [ ] Avoid relying only on mocked service behavior for persistence guarantees.
- [ ] Isolate test data so tests can run repeatedly.
- [ ] Document routes or operations not yet implemented rather than marking them as passed.