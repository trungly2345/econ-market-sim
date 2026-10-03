MarketDataService
[[Class Design Review Template]]

USE CASE:
Retrieve and prepare data for a specific market.

DEPENDENCIES:
EiaClient

RETURNS:
MarketObservation(s)
containing normalized price/quantity/date/unit information.

DOES:
- ask EiaClient for data
- validate/filter data
- convert EiaObservationDto → MarketObservation
- combine/align price and quantity observations

DOES NOT:
- construct HTTP requests
- know EIA URLs/API mechanics
- parse raw EIA JSON
- calculate equilibrium
- contain supply/demand formulas
- talk directly to the frontend