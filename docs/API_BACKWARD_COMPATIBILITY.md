# API Backward Compatibility Checklist

Before changing a public endpoint, consider existing clients and deployed frontend versions.

- [ ] Avoid renaming or removing response fields without a migration plan.
- [ ] Avoid changing field types or meanings unexpectedly.
- [ ] Preserve established status codes and error shapes where practical.
- [ ] Treat new required request fields as a potentially breaking change.
- [ ] Keep pagination and sorting semantics stable.
- [ ] Add optional fields in a way existing clients can tolerate.
- [ ] Update API examples and OpenAPI documentation.
- [ ] Test a representative existing client request against the new version.
- [ ] Communicate any breaking changes and the expected upgrade path.

If a breaking change is necessary, consider versioning or a staged deprecation rather than silently changing behavior.