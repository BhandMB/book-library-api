# Book Library API Authentication and Authorization Boundary Test Matrix

## Purpose
Verify authentication and object-level authorization consistently across API routes.

## Test dimensions
Test anonymous, authenticated ordinary user, privileged user, and resource owner/non-owner contexts. Include requests with missing, expired, malformed, and revoked credentials.

## Route review
For each read, create, update, delete, checkout, and return operation, document:
- Required authentication
- Required permission or ownership
- Expected response for denied access
- Whether the action is audited
- Whether data is modified on denial

## Negative test cases
1. Anonymous access to a protected route.
2. User reads another user's private loan.
3. User changes a resource ID to access another record.
4. Privileged action attempted by an ordinary user.
5. Expired token used after logout.
6. Resource ownership changes during a concurrent request.
7. Authorization failure does not reveal whether a sensitive record exists, where appropriate.

## Implementation review
Enforce authorization in backend services or route policies, not only in client navigation. Apply checks before returning sensitive fields and before performing writes.

## Evidence
Maintain a route-to-role matrix and automated integration tests for both allowed and denied paths.
