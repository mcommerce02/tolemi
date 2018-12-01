## Spring Boot Consume REST API

In this demo provide a single API endpoint "http://localhost:9191/records/{index}" that receives an index (0 based) and returns the corresponding record from the dataset found in 
Providence REST API https://data.providenceri.gov/resource/r6n7-qjr6.json. 

This is done via consuming the API https://data.providenceri.gov/resource/r6n7-qjr6.json and return the string.

To run the test. 
Download the git repository 
Change the directory to "spring-boot-consumeapi"
Issue the command  ./mvnw spring-boot:run
Open a browser and navigate to "http://localhost:9191/records/40000"

The performance depends on the time taken to pass data (Network) between
REST API "http://localhost:9191/records/{index}" and
Providence REST API "https://data.providenceri.gov/resource/r6n7-qjr6.json".  

Troubleshoot production depends on checking on how long it takes to retrieve data from "https://data.providenceri.gov/resource/r6n7-qjr6.json"
and how long it takes to retrieve data from "http://localhost:9191/records/{index}". 

The retrieval of data depends heavily on filtering 
Providence REST API "https://data.providenceri.gov/resource/r6n7-qjr6.json" which can be an issue if the dataset had 50M records 
or more than 1TB and the Providence database is not indexed.  If that is the case, we might have to download the data to "local" database, 
partition the tables, index the tables to improve the speed of retrieving data. 