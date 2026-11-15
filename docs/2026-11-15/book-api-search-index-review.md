# Book API Search Index Review

## Search behavior
Document searchable fields, case sensitivity, partial-term behavior, and empty-query handling.

## Data consistency
If a separate search index is used, define update/delete propagation and stale-result repair. If the database is queried directly, review indexes against actual filter and sort combinations.

## Test matrix
Cover punctuation, diacritics, long queries, no matches, duplicate titles, and simultaneous updates.

Search results should be deterministic for a fixed dataset, bounded in execution cost, and scoped to the caller's access.