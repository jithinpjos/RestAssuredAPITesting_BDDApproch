package RestAssuredTest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TC005_BasicValidation_Json {
	
	//Test Status Code
	
	@Test(priority=1)
	public void testStatusCode() {
		RestAssured.baseURI="http://services.groupkt.com/country/get/iso2code/IN";
		
		given()
		.when()
			.get()
		.then()
		.statusCode(200);
	}

	//Log Response
	
	@Test(priority=2)
	public void logResponse() {
		RestAssured.baseURI="http://services.groupkt.com/country/get/iso2code/IN";
		
		given()
		.when()
			.get()
		.then()
		  .log().all();
	}
	
	//Verify Single content in Response body
	
	@Test(priority=3)
	public void verifySingleContent() {
		RestAssured.baseURI="http://services.groupkt.com/country/get/iso2code/IN";
		
		given()
		.when()
			.get()
		.then()
		  .body("RestResponse.result.name", equalTo("India"));
	}
	
	//Verify multilpe content in Response body
	
		@Test(priority=4)
		public void verifyMultipleContent() {
			RestAssured.baseURI="http://services.groupkt.com/country/get/all";
			
			given()
			.when()
				.get()
			.then()
			  .body("RestResponse.result.name", hasItems("India","Antarctica","Bahamas"));
		}
		
		//Setting Parameter and Headers
		
			@Test(priority=4)
			public void setParametersAndHeaders() {
				RestAssured.baseURI="http://services.groupkt.com/country/get/iso2code/IN";
				
				given()
				.header("MyHeader", "John")
				   .params("MyParameter", "JohnP")
				   
				.when()
					.get()
				.then()
				  .statusCode(200)
				  .log().all();
			}
}
