# Backup and Restore Notes

## Minimum recovery checklist
1. Record the database engine and schema version.
2. Take a consistent backup before a release.
3. Restore into an isolated environment.
4. Run smoke tests against the restored data.
5. Document the restore timestamp and result.

## Safety checks
- Never store backup credentials in the repository.
- Verify that sample data does not contain secrets or personal data.
