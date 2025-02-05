ReceiptProcessor
Receipt processor spring boot application

Tools required : JAVA 1.8, Docker Hub.

Step#1. git checkout Step#2. from command line run -- "docker build -t receiptprocessor_image ." Step#3. from command line run -- "docker run -p 8080:8080 receiptprocessor_image"

Application will be up and running at http://localhost:8080/

POST API http://localhost:8080/receipts/process

     Below is Sample JSON as request body

      {
        "retailer": "M&M Corner Market",
        "purchaseDate": "2022-03-20",
        "purchaseTime": "14:33",
        "items": [
          {
            "shortDescription": "Gatorade",
            "price": "2.25"
          },{
            "shortDescription": "Gatorade",
            "price": "2.25"
          },{
            "shortDescription": "Gatorade",
            "price": "2.25"
          },{
            "shortDescription": "Gatorade",
            "price": "2.25"
          }
        ],
        "total": "9.00"
      }
GET API http://localhost:8080/receipts/{id}/points (Use the Id value returned for POST API(above) response)
