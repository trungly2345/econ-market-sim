# MarketObservation Design Decisions

## Purpose

`MarketObservation` represents a normalized, observed market data point after external API data has been validated and converted into application-friendly types.

## Fields

- `YearMonth period`
- `BigDecimal observedPrice`
- `PriceUnit priceUnit`
- `DataSource source`

## Why These Types

### `YearMonth` instead of `String`

The application may need to:

- Sort observations chronologically
- Filter by date range
- Compare periods
- Align price and quantity observations
- Find the latest observation

Using `YearMonth` gives the period actual temporal meaning instead of treating it as display text.

### `BigDecimal` instead of `double`

Market prices are decimal values.

`BigDecimal` helps preserve the decimal representation and avoids floating-point approximation issues that can occur with `double`.

It does not make the original EIA data more accurate; it simply avoids introducing additional precision errors.

### `PriceUnit` enum instead of `String`

Using an enum prevents inconsistent values such as:

```text
$/MCF
$/mcf
$ / MCF
USD_PER_MCF