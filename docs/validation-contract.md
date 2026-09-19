# Validation Contract

The API should reject invalid input consistently:

- Required fields must be present and non-blank.
- Identifiers must use the documented type and format.
- Invalid payloads should return a clear 4xx response.
- Error responses should be safe for clients to display and should not expose stack traces.
- Controller tests should cover both valid and invalid payloads.
