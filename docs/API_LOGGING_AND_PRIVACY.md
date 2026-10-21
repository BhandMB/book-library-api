# API Logging and Privacy Checklist

Use this checklist when reviewing application logging and API error handling.

- [ ] Do not log passwords, authorization headers, access tokens, or session secrets.
- [ ] Minimize personal data in request and response logs.
- [ ] Avoid returning stack traces, SQL statements, or infrastructure details to clients.
- [ ] Record enough non-sensitive context to diagnose failures.
- [ ] Use correlation IDs where the application or deployment supports them.
- [ ] Keep log levels appropriate for expected validation and client errors.
- [ ] Restrict access to logs and define retention according to the deployment's requirements.
- [ ] Review exception handlers for accidental disclosure.
- [ ] Test that common error responses remain useful without exposing internal details.