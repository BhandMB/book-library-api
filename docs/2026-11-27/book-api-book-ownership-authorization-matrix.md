# Book API book ownership authorization matrix

Every object-level operation must authorize the caller against the specific record. Hiding a button in the client is not authorization.

| Operation | Anonymous | Owner | Non-owner | Admin (if supported) |
|---|---|---|---|---|
| List public books | Policy-defined | Allowed | Allowed | Allowed |
| Read public book | Policy-defined | Allowed | Allowed | Allowed |
| Create book | Denied | Own record only | Own record only | Policy-defined |
| Update book | Denied | Allowed | Denied | Policy-defined |
| Delete book | Denied | Allowed | Denied | Policy-defined |

## Implementation
Load the resource and evaluate ownership using the authenticated principal, not a client-supplied owner ID. Apply checks to nested routes and bulk operations. Choose consistent 403/404 behavior according to information-disclosure policy.

## Regression tests
Attempt access using another user's identifier, alter owner fields in request bodies, invoke nested endpoints directly, and test deleted/nonexistent resources. Denied operations must not mutate data or emit success audit events.
