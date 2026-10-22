# API Negative Test Cases

Use the actual API routes and request schema from the project when running these checks.

| Case | Check | Expected behavior |
|---|---|---|
| Malformed JSON | Submit invalid JSON | Consistent client-error response |
| Missing required field | Omit a required value | Validation error with useful field details |
| Invalid identifier | Use an invalid ID format | Documented client-error response |
| Unknown resource | Request a nonexistent resource | Consistent not-found response |
| Unsupported method | Use a method not supported by a route | Method-not-allowed response where applicable |
| Unauthorized access | Call a protected route without credentials | Authentication required |
| Unexpected server failure | Exercise a controlled test failure | Safe error response without stack trace |

Capture status, response shape, and whether state changed. These are planned checks, not recorded test results.