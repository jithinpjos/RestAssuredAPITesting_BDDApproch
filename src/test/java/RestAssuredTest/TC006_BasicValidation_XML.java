package RestAssuredTest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TC006_BasicValidation_XML {
	
	//Verifing single content in the xml response
	
	@Test(priority=1)
	public void verifySingleContent() {
		RestAssured.baseURI="http://www.thomas-bayer.com/sqlrest";
		RestAssured.basePath="/CUSTOMER/20";
		
		given()
	    .when()
	    		.get()
	    .then()
	      .body("CUSTOMER.ID", equalTo("20"));
	}
	
	//Verifing Multiple content in the xml response
	
		@Test(priority=2)
		public void verifyMultipleContent() {
			RestAssured.baseURI="http://www.thomas-bayer.com/sqlrest";
			RestAssured.basePath="/CUSTOMER/20";
			
			given()
		    .when()
		    		.get()
		    .then()
		      .body("CUSTOMER.ID", equalTo("20"))
			  .body("CUSTOMER.FIRSTNAME", equalTo("Janet"))
			  .body("CUSTOMER.LASTNAME", equalTo("Schneider"))
			  .body("CUSTOMER.STREET", equalTo("309 - 20th Ave."))
			  .body("CUSTOMER.CITY", equalTo("Oslo"));
		}
		//Verifing Multiple content in the xml response in one go
		
			@Test(priority=3)
			public void verifyMultipleContentInOneGo() {
				RestAssured.baseURI="http://www.thomas-bayer.com/sqlrest";
				RestAssured.basePath="/CUSTOMER/20";
				
				given()
			    .when()
			    		.get()
			    .then()
			    
				  .body("CUSTOMER.text()", equalTo("20JanetSchneider309 - 20th Ave.Oslo"));
			}
			
			//Verifing Multiple content in the xml response with xml path
			
			@Test(priority=4)
			public void verifyContentWithXpath() {
				RestAssured.baseURI="http://www.thomas-bayer.com/sqlrest";
				RestAssured.basePath="/CUSTOMER/20";
				
				given()
			    .when()
			    		.get()
			    .then()
			    
				  .body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Janet"));
			}
			
	//Verifing Multiple content in the xml response with xml path method 2
			
			@Test(priority=5)
			public void verifyContentWithXpathSecondMethod() {
				RestAssured.baseURI="http://www.thomas-bayer.com/sqlrest";
				RestAssured.basePath="/INVOICE";
				
				given()
			    .when()
			    		.get()
			    .then()
			    
				  .body(hasXPath("/INVOICEList/INVOICE[text()=30]"));
			}
}
