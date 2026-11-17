# Book API Object Ownership Authorization

## Risk
A caller may change a book or collection identifier in a request and access another user's resource.

## Review checks
- Resolve the authenticated principal on the server; never trust owner identifiers supplied by the client.
- Apply ownership checks to read, update, delete, and nested-resource operations.
- Verify bulk actions and exports use the same authorization policy.
- Return a consistent denial response without leaking private object details.

## Test matrix
Use two separate accounts and attempt cross-account access for every supported operation, including guessed identifiers and modified payload ownership fields.