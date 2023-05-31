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
	1. abc-common-domain: To share common Java beans over other project as dependencies. <br> 
	2. abc-dataadapter: Read and validate product xml file and send to processor using event <br> 
	3. abc-product-processor: Consume event and store data in database(mysql) <br>
	4. abc-gateway: As the entry point for client requests to an API. <br>
	
* Docker compose file to setup below tools
	1. Mysql 8 <br>
	2. Zookeeper <br>
	3. Kafka <br>
	
#### 2. Setup tools 
* Docker compose file with basic setup of mysql and kafka  
* Requirements:
	1. docker >= 17.12.0+ <br>
	2. docker-compose <br>
* Run this command `docker-compose up -d`






