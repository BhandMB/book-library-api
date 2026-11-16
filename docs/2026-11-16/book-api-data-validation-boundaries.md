# Book API Validation Boundary Cases

## Fields to examine
Review title, author, ISBN, publication date, category, and optional descriptive fields against the actual API contract.

## Boundary scenarios
Test missing values, whitespace-only strings, minimum and maximum lengths, malformed ISBN values, impossible dates, unsupported enum values, and unexpected extra fields.

## Expected behavior
Return field-specific validation feedback with a stable error structure. Reject invalid data before persistence and avoid exposing internal exception details.