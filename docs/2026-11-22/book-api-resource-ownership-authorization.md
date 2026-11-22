# Book API Resource Ownership Authorization

Date: 2026-11-22

## Purpose
Prevent authenticated users from reading or modifying resources outside their permitted ownership scope.

## Design rules
Resolve the resource and enforce ownership or delegated permission in the service layer. Do not trust caller-supplied owner identifiers. Apply the same checks to nested resources, attachments, search results, exports, and update/delete operations.

## Response behavior
Choose a consistent not-found or forbidden policy that does not disclose resource existence beyond the intended security boundary. Ensure error messages and logs do not expose private resource content.

## Test scenarios
- [ ] Owner can access permitted operations.
- [ ] Different user cannot read or modify the resource.
- [ ] Changing a path or body identifier does not bypass checks.
- [ ] Nested resource access inherits the correct scope.
- [ ] Search and pagination do not reveal inaccessible records.

## Scope
Authorization design checklist; no endpoint behavior was changed or tested.