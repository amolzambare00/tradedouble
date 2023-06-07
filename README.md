# Tradedouble Assignment 
## Description
The ABC Company operates as an affiliate marketing firm, facilitating
connections between product advertisers and publishers. Advertisers are
required to upload their products and provide relevant offer details to the
platform, which can be accessed by publishers through REST APIs.
Your Task: Develop a Java program that can handle the following tasks:
1. Upload and Process XML Files: Create a feature that allows advertisers to
upload large XML files containing product lists.
2. Store Data: Process the data from the XML files and store it in a database.
You can use a relational database such as MySQL
3. Create REST API: Create a REST API using a framework such as Spring Boot
that allows publishers to download the stored data in JSON, XML, or CSV
format.
4. XML file and XSD: Platform Assignment

## Implementation
#### 1. Create a Root Project
* Root project contain child project as below: <br>
     1. abc-dataadapter: Read and validate product xml file and send to processor using event <br> 
     2. abc-product-processor: Consume event and store data in database(mysql) <br><br>
	
* "docker-compose.yml "Docker compose file to setup below tools
	1. Mysql 8 <br>
     2. Zookeeper <br>
     3. Kafka <br>
     4. Redis <br>
	
#### 2. Setup tools 
* Docker compose file with basic setup of mysql and kafka  
* Requirements:
	1. docker >= 17.12.0+ <br>
	2. docker-compose <br>
* Run this command `docker-compose up -d`
* mvn clean install projects and run.

#### 3. Used Tech Stack 
* Java 11
* Spring boot 2.7 
* Used above plugins: <br>
	*Spring boot Web, JPA, batch, lombok, kafka, redis, flyway, junit-jupiter, mockito, rest-assured*
* Mysql 8
* kafka: Asynchronous communication between service read xml file using batch and send to process and save into database to other service. 
* Spring Batch: Read big file and read process small chunk 
* redis: To get uploaded file status Used common key value DB to store proceed record status amoung the services

#### 4: Implementation
	1. abc-dataadapter 
		This project spring boot sevice used jpa with mysql. Use spring batch to read and process big file. send to other service using kafka producer.
		
	2. abc-product-processor 
		As kafka consumer read product and save into database.
		
	3. Spring Batch
		Use to read and process big file. Create one job to read xml file and write into kafka producer to send product to consumer to process.
	
	4. Unit testing
		1. Repository testing: 
			demonstrated abc-product-processor > test > repository > ProductImageRepositoryTests.java. Use jupiter and mockito to test Repository
		2. Service testing
		     demonstrated abc-product-processor > test > service > ProductImageServiceImplTests.java. Use jupiter and mockito to test service layer
		     
	5. Integration testing 
		demonstrated abc-product-processor > test > controller > ProductIntegrationTests.java. Used rest assured for integration testing.
		
	5. Flyway
		Used to manage database changes as it work as version control for database.
		
	6. Jaxb to generated java bean and used jaxb and XStream for read xml to java object 

#### 5 End points
	1. Upload product xml file	
	curl --location --request POST 'localhost:8180/dataadapter/v1/product/upload' --header 'Content-Type: multipart/form-data' --form 'file=@"abc-dataadapter/src/main/resources/sample/Products.xml"'
	
	2. Get asynchronous file upload status 
	curl --location --request GET 'localhost:8180/dataadapter/v1/product/status?processId=<return in response of upload service>'
	
#### Note:
	Their is some issue in xsd file, after using new xsd still generated wrong java class which not able to handle list of element like category so please sample file provided in project.  			     
		      
		 		  



