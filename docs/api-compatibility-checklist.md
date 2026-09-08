# API Compatibility Checklist

Before changing a public endpoint, verify:

- Existing routes and HTTP methods remain unchanged unless the README documents the migration.
- Response fields are not removed without a compatibility note.
- New fields are optional for existing clients when possible.
- Status codes remain predictable for success, validation, not-found, and conflict cases.
- Pagination and filtering parameters have documented defaults.
- API examples are updated alongside implementation changes.
