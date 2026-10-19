# API Authorization Review Checklist

Use this checklist for endpoints that read or modify library data. It is a review aid, not proof that authorization is already implemented.

- [ ] Identify whether the endpoint is public or requires authentication.
- [ ] Verify permissions on the server for every protected operation.
- [ ] Check that users cannot access records outside their permitted scope by changing an ID.
- [ ] Do not treat a hidden button or frontend route as an authorization boundary.
- [ ] Ensure create and update requests cannot assign protected fields without permission.
- [ ] Return consistent unauthorized and forbidden responses.
- [ ] Avoid leaking private data in error messages and logs.
- [ ] Add tests for anonymous, authorized, and unauthorized callers.
- [ ] Re-review authorization when routes or data relationships change.