# Phone book

Reverse directory service that satisfies the following use cases:
1.Upload user’s phonebook into DB
2.Query user profile by number
3.Query user profiles by name

## Getting Started

2 Profiles (.yml files instead of .properties): Development and Production 
Development profile will allow for debug level for logs using logback + allow connection to development database (H2 database)
Production profile will allow for info level for logs using logback + allow connection to production database (postgre database)
use jetty as an embedded server instead of tomcat
Maven flyway plugin for DB migrations
Lombok for entities
implement unit tests using spring’s junit + mockito


### Prerequisites

Java 7 or 8 installed on your machine
maven installed on your machine
postgresql installed on your machine
postman installed on your machine(to test RESTful API)

### Installing

you just have to build the project using maven command : mvn clean install
in cas you want to skip test use : mvn clean install -DskipTest

then run the jar you got in your target : java -jar springboot-handson-1.0-SNAPSHOT

## Test 

For testing the REST APIs using postman:
_________________________________________

____ To add user ____

http://localhost:8080/user/addUser/dbUser

____ To get specific user's details ____

http://localhost:8080/user/userById/1

____ To get users details who have the save name ____

http://localhost:8080/user/userByName/dbUser

____ To save contacts realted to specific user ____

http://localhost:8080/contacts/saveContacts/1

and as a request body

[{
	"name" : "Tom",
	"number":"123"
},{
	"name" : "Martha",
	"number":"123"
},{
	"name" : "Billy",
	"number":"123456"
},{
	"name" : "Ms.Green",
	"number":"1221341234"
}]

____ To get contacts by name ____

http://localhost:8080/contacts/contactByName/Tom

____ To get contacts by number ____

http://localhost:8080/contacts/contactByNum/123

____ To get contacts by name ____

http://localhost:8080/contacts/contactByName/Tom

____ To get contacts related to specific user ____

http://localhost:8080/contacts/contactByUser/1

____ To get specific contact by id ____

http://localhost:8080/contacts/contactById/1

____ To update contact ____

http://localhost:8080/contacts/updateContact/1

and as a request body
{
	"name" : "Ms.Green",
	"number":"1221341234"
}

## Built With

* [Java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - The java version used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring boot](https://projects.spring.io/spring-boot/) - For embedded server and auto configuration
* [H2](http://www.h2database.com/html/main.html) -For in-memory database
* [postgresql](https://www.postgresql.org/) - For file based database
* [flyway](https://flywaydb.org/) -for DB migrations
* [lombok](https://projectlombok.org/) -For entities
* [mocikto](http://site.mockito.org/) -For test
* [flyway test](https://github.com/flyway/flyway-test-extensions) - For test
* [logback](https://logback.qos.ch/) - For creating logs
* [postman](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en) -For testing the REST Api

contact me : karim.abdelmohsen.1992@gmail.com


