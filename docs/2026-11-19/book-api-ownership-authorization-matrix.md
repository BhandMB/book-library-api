# Book API Ownership Authorization Matrix

## Purpose
Ensure users can access only the book records and actions permitted by the product's ownership model.

## Matrix to confirm
| Operation | Anonymous | Authenticated owner | Other authenticated user | Administrator |
|---|---|---|---|---|
| List public books | Policy-defined | Allowed | Allowed | Allowed |
| View private book | Denied | Allowed | Denied | Policy-defined |
| Create personal book | Denied | Allowed | Allowed for own account | Allowed |
| Update personal book | Denied | Allowed | Denied | Policy-defined |
| Delete personal book | Denied | Allowed | Denied | Policy-defined |

## Enforcement requirements
- Resolve the authenticated principal from trusted server-side security context.
- Compare ownership using persisted relationships, not request-supplied owner IDs.
- Apply authorization to every read, update, and delete path.
- Avoid leaking protected resource existence through inconsistent error messages.
- Keep administrative exceptions explicit and auditable.

## Tests
Cover owner access, cross-account identifier substitution, missing authentication, deleted owners, and administrative access boundaries. Adapt the matrix to the repository's actual product rules before implementation.