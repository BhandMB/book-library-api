# API Contract Review Checklist

Use this checklist when adding or changing an endpoint so API consumers can rely on consistent behavior.

- [ ] HTTP method and path match the operation's intent.
- [ ] Request fields, required values, and validation rules are documented.
- [ ] Success status codes and response schemas are documented.
- [ ] Validation, not-found, authorization, and conflict cases are covered.
- [ ] Collection endpoints document pagination, filtering, and sorting where supported.
- [ ] Error responses use a consistent structure.
- [ ] Responses avoid exposing persistence entities or internal implementation details unnecessarily.
- [ ] Examples match the current implementation.
- [ ] Automated tests cover representative success and failure cases.
- [ ] Changes that may affect existing clients are called out in release notes.