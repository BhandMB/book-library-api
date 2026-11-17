# Book API Request Correlation Identifiers

## Contract
Define whether the service accepts a trusted inbound correlation identifier or generates one when absent. Validate length and allowed characters before reuse.

## Logging
Include the identifier in structured request and error logs. Do not use it as an authentication credential or include sensitive request bodies in logs.

## Propagation
Document propagation to downstream services and include the identifier in support-facing error references where appropriate.

## Tests
Verify missing, valid, malformed, and oversized identifiers, plus propagation across an internal service call. Ensure one request's identifier cannot leak into another request.