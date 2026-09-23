# API Contract Review — 2026-09-23

- Keep success responses stable for existing clients.
- Return validation failures with actionable field-level messages.
- Use consistent not-found and malformed-ID behavior.
- Avoid exposing stack traces, SQL details, or secrets.
- Add regression coverage whenever a response contract changes.
