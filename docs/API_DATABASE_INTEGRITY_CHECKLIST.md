# API Database Integrity Checklist

Use this checklist when changing data access, entity mappings, or service-layer transactions.

- [ ] Required fields are validated before persistence.
- [ ] Unique business identifiers have appropriate database constraints where needed.
- [ ] Relationships have intentional ownership and deletion behavior.
- [ ] Multi-step writes use transactions when partial completion would be invalid.
- [ ] Missing related records are handled predictably.
- [ ] Concurrent requests cannot silently violate critical invariants.
- [ ] Database errors are translated into safe API responses.
- [ ] Tests exercise persistence behavior against the configured test database.
- [ ] Schema and migration changes are documented and repeatable.
- [ ] Tests confirm rejected operations do not leave partial records.