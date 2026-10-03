
## 1. Purpose

**Class name:**  [[MarketDataService.java]]

**What concept or use case does this class represent?**
Retrieve and prepare data for a specific market.

**Describe its responsibility in one sentence.**
Use and retrieve data for a specific market, performing conversion logic. 

If I cannot describe the class in one sentence, is it doing too much?

---

## 2. Inputs and Outputs

### Inputs

What information does this class receive?

- Parsed Json response from EIA client HTTP request

Where do those inputs come from?
EIAClient.java - > fetchData()
### Outputs

What does this class return or produce?
- return normalized price, quantity, period, and unit 


Who consumes that output?
MarketDataObservation(s)

---

## 3. Ownership

### What SHOULD this class own?

- a method to normalize price, unit, quantity, period 
- conversion logic including error handling 

### What should definitely NOT live here?

- HTTP request 
- setters/getters 

For each responsibility, ask:

> If this logic doesn't belong here, which component should own it?

Possible owners:

- Controller
- Application Service
- Domain Object
- Repository
- External API Client
- DTO
- Mapper / Adapter
- Configuration

---

## 4. Dependencies

What other components does this class need?

| Dependency | Why is it needed?                    |     |     |
| ---------- | ------------------------------------ | --- | --- |
| Eia Client | data to convert to normalized values |     |     |
|            |                                      |     |     |
|            |                                      |     |     |

Ask:

> Is this dependency necessary, or am I coupling these classes unnecessarily?

Also ask:

> Does this dependency point in the correct architectural direction?

Example:

```text
Controller
    ↓
Service
    ↓
Domain

Service
    ↓
Client / Repository