# API Release Compatibility Notes

Use this checklist when changing an endpoint or response model.

- Preserve existing methods and paths unless the change is intentional.
- Add new request fields as optional when possible.
- Keep existing response fields and types stable.
- Document status-code or error-shape changes.
- Verify success, validation failure, missing-resource, and malformed-ID cases.
- Confirm the application starts with the documented configuration.
