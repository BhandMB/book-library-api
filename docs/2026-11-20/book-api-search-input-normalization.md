# Book API Search Input Normalization

Date: 2026-11-20

## Goal

Make search behavior consistent while preventing malformed input from creating expensive or unsafe queries.

## Normalization policy

- Trim leading and trailing whitespace.
- Define case sensitivity and Unicode normalization explicitly.
- Set a maximum query length.
- Treat an empty or whitespace-only query consistently.
- Escape wildcard characters according to the chosen search semantics.
- Keep user input parameterized; never concatenate it into SQL or JPQL.

## Search semantics

Document whether matching uses exact, prefix, or substring behavior for title, author, and category. Define how multiple terms combine and how results are ordered. Include a stable secondary sort key to avoid result movement between pages.

## Validation cases

- [ ] Empty query behavior is documented.
- [ ] Maximum length is enforced.
- [ ] Unicode and punctuation are handled predictably.
- [ ] Wildcard characters cannot broaden queries unexpectedly.
- [ ] Query plans remain acceptable for expected data volume.

## Scope

This document is a contract proposal, not a claim of measured search performance.