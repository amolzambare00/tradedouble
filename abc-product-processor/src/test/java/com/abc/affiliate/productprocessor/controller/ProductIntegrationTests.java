package com.abc.affiliate.productprocessor.controller;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@EmbeddedKafka
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ActiveProfiles("test")
@DisplayName("Product Controller Integration Tests")
class ProductIntegrationTests {
	
	@LocalServerPort
	private int port;
	
	static {
	    System.setProperty(EmbeddedKafkaBroker.BROKER_LIST_PROPERTY, "spring.kafka.bootstrap-servers");
	}
	
	//@Autowired
    //private EmbeddedKafkaBroker embeddedKafkaBroker;
    
    @BeforeAll
    void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        //RestAssured.basePath = "http://localhost";
        RestAssured.port = port;
    }
    
    @Test
    @DisplayName("Product images not avaialble for provided product id.")
    void testRetrieveProductImagesByProductId() {
        given()
        	.header("Content-Type", ContentType.ANY)
        .when()
                .get("productprocessor/v1/product/images/getbyproductid/"+11)
        .then()
                .assertThat()
                .statusCode(500)
                .and()
                .header("Content-Type", ContentType.JSON.toString())
                .and()
                .body("status", is(500))
                .and()
		        .body("message", startsWith("No row with the given identifier exists"));
    }
    
    @Test
    @DisplayName("Get product images for provided product id.")
    void testRetrieveProductImagesByProductIdReturnImages() {
    	given()
    		.header("Content-Type", ContentType.ANY)
    	.when()
            .get("productprocessor/v1/product/images/getbyproductid/"+1)
        .then()
            .assertThat()
            .statusCode(200)
            .and()
            .header("Content-Type", ContentType.JSON.toString())
            .and()
	        .body("size()", is(1));
    }
}
