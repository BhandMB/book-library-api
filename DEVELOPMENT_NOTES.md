# Book Library API Verification Checklist

Use this checklist when changing API behavior.

- Verify request validation for required book fields and invalid identifiers.
- Check successful create, read, update, and delete flows against the configured database.
- Confirm missing resources return consistent error responses.
- Exercise boundary cases such as empty search results and duplicate or malformed input.
- Keep endpoint documentation aligned with controller behavior.
- Run automated tests before merging and avoid committing secrets or local configuration.
