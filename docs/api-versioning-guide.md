# API Versioning Guide

## Compatibility rules
- Preserve existing response fields whenever possible.
- Add optional fields before removing or renaming anything.
- Document breaking changes in the release notes.
- Keep error responses predictable for clients.

## Review cases
- Existing clients can call the current endpoint without changes.
- New clients can opt into a newer version explicitly.
- Deprecated endpoints return a clear migration message.
- API documentation shows request and response examples for each version.
