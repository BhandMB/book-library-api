# API Release Checklist — 2026-09-10

## Contract checks
- Confirm endpoint paths, HTTP methods, and status codes match the README.
- Verify validation errors return a stable JSON shape.
- Confirm pagination defaults and maximum page sizes are documented.
- Check that unknown resource IDs return a clear 404 response.

## Operational checks
- Run the full test suite before tagging a release.
- Verify the application starts with the documented environment variables.
- Confirm database migration or initialization steps are reproducible.
- Review logs for accidental secrets or stack traces in client responses.
