


Fetch from client data to store into the database 

How would this go at high level? 

EIA API -> Eia Client -> MarketService -> Entity -> Repository -> Database 

- MarketService 
  - Should take the price from the client response and store it ObservedPrice Records 
  - After fetching price, try to think about it gets store in a array list
    

   insertPriceObservation(entity) 
           call getGasPrice() 
           map the results from getGasPrice to store it in the entity class to save to DB



           
    