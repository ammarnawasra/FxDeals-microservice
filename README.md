
# Fx-Deals Service

This is to analyze fx deals by accepting deals and persisting in DB. Validation is on fields to ensure correct data are persisted in the data.


##  Run - Docker
```sh
docker-compose up
```

## Project Run
#### How to run the project
- Go to application.yml in resources package and input your username and password for MYSQL

- Run this command
```sh
 mvn clean spring-boot:run
```

## PROJECT DOCUMENTATION

#### Technology Used
- SPRINGBOOT
- MYSQL
- DOCKER

# Project Packages
#### Resource
- POST - fxDeal/create - Create a deal
- GET - fxDeal/get/{id} - Retrieve a deal by id
- GET - fxDeal/deals - Retrieve list of deals

### Service and Impl
- The business logic is in the impl package. The service class which is an interface implements the impl class.


#### Model
- id - Unique id with Datatype: Long
- fromCurrency - ISO Currency from deal with Datatype: Currency
- toCurrency - ISO Currency to deal with Datatype: Currency
- dealTimestamp - Instantaneous time with Datatype: Instant
- dealAmount - Amount with Datatype: BigDecimal

#### Logging
- Logging used to log errors for controllers, services and repositories, spring ASPECT was used for cross-cutting concerns

### Request body
```json
{
  "fromCurrency": "USD",
  "toCurrency": "JOD",
  "dealAmount":1402
}
```

### Success Response
```json
{
  "status": "Success",
  "message": "Successful",
  "data": {
    "id": 5,
    "fromCurrency": "USD",
    "toCurrency": "JOD",
    "amount": 1402,
    "createdAt": "2024-03-1T16:10:26.741829Z"
  }
}
```

### Error Response
if "fromCurrency is null"
```json
{
  "status": "Failed",
  "message": "An error has occurred at entity",
  "data": {
    "statusCode": 422,
    "message": [
      "Deal from_currency is not valid."
    ]
  }
}
```

TEST
- Unit test in the test folder
