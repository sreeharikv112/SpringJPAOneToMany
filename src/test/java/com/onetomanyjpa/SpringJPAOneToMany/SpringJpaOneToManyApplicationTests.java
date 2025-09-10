package com.onetomanyjpa.SpringJPAOneToMany;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

import io.restassured.RestAssured;


@SpringBootTest(
classes = com.onetomanyjpa.demoapp.SpringJpaOneToManyApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringJpaOneToManyApplicationTests {

	@ServiceConnection
	static MySQLContainer mysql = new MySQLContainer<>("mysql:8.0");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setupTest(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}
	
	@Test
	void shouldCreateProduct() {
		String requestBody = """
				{
  "customer": {
    "name": "Usertest1",
    "email": "Usertest1@gmail.com",
    "gender": "female",
    "products": [
      {
        "id": 500,
        "productName": "Drinks",
        "qty": 2,
        "price": 51
      },
      {
        "id": 896,
        "productName": "Juice",
        "qty": 3,
        "price": 2400
      }
    ]
  }
}
				""";
RestAssured.given().contentType("application/json")
.body(requestBody)
.when()
.post("/customer-service/api/placeOrder")
.then()
.log().all() 
.statusCode(201)
.body("id", Matchers.notNullValue())
        .body("name", Matchers.equalTo("Usertest1"))
        .body("email", Matchers.equalTo("Usertest1@gmail.com"))
        .body("products[0].productName", Matchers.equalTo("Drinks"))
        .body("products[1].qty", Matchers.equalTo(3));
	}	
}
