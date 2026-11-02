


**Fetch from client data to store into the database**

- Price 
- Quantity 
How would this go at high level? 

<p> EIA API -> Eia Client -> MarketService -> Entity -> Repository -> Database </p>

- MarketService 
  - Should take the price from the client response and store it ObservedPrice Records 
    - After fetching price, try to think about it gets store in an array list
    
      savePriceObservation(entity) 
             call getGasPrice() 
             map the results from getGasPrice to store it in the entity class to save to DB

      saveQuantityObervation(entity)
             call getGasConsumption
      map the results from getGasConsumption to store it in the entity class to save to DB
    