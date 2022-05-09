##The Retails Store Discounts Project

#Instructions

This project will calculate the final transaction amount on the basis of User type.
Provide discount on every purchase if it is grater than $100 and also provide additional discount on employees, affiliated customer and customer who has linked with store from more than 2 years


#Technology used:

* Java 1.8
* SpringBoot
* Maven
* Junit using Mockito.
* Eclipse

Application you can directly run with SpringBoot starter class TheRetailStoreDiscountsApplication.java or 
We also provide one rest controller in the implementation which you can check with Postman


Run mvn clean test from the root folder, 

postman URL: GET- http://localhost:8080/retailstore/amount

Headers - Content-Type - application/json
Accept - */*

Body-
 choose row

click on Send Request to Server,

we will get below Json response get it.



==========================
CURL  Request 
----------
curl --location --request GET 'http://localhost:8080/retailstore/amount' \
--header 'Content-Type: application/json' \
--header 'Accept: */*' \
--data-raw ''

Response
----------
GET http://localhost:8080/retailstore/amount: {
  "Network": {
    "addresses": {
      "local": {
        "address": "::1",
        "family": "IPv6",
        "port": 51968
      },
      "remote": {
        "address": "::1",
        "family": "IPv6",
        "port": 8080
      }
    }
  },
  "Request Headers": {
    "content-type": "application/json",
    "accept": "*/*",
    "user-agent": "PostmanRuntime/7.29.0",
    "postman-token": "f6381959-7f00-4a9c-a85d-7c555444c0a4",
    "host": "localhost:8080",
    "accept-encoding": "gzip, deflate, br",
    "connection": "keep-alive"
  },
  "Request Body": "",
  "Response Headers": {
    "content-type": "text/plain;charset=UTF-8",
    "content-length": "31",
    "date": "Thu, 09 May 2022 17:32:34 GMT",
    "keep-alive": "timeout=60",
    "connection": "keep-alive"
  },
  "Response Body": "Total Amount To Be Paid: 4620.0"
}

## More information about the project 
- Products can be added or remove in cart with there quantity using CartProduct.
- After adding products, the application will calculate the total amount for the products added in the cart.
- Calculate in store discount and the special discount of specific User calculated in ProcessingCart 
- Temporary print logic is written with SOP statements, which will display on console when run project with SptingBootApplication starter class(TheRetailStoreDiscountsApplication.class) 
