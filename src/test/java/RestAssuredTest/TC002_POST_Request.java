package RestAssuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class TC002_POST_Request {
	
	public static HashMap map =new HashMap();
	
	@BeforeClass
	public void postData() {
		map.put("FirstName",Utility.RandomFirstName());
		map.put("LastName",Utility.RandomLastName());
		map.put("UserName",Utility.RandomUserName());
		map.put("Password",Utility.RandomPassword());
		map.put("Email",Utility.RandomEmail());
		
		

		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
		
	}
	
	@Test
	public void postCustomerRegistation() {
		
		given()
		      .contentType("application/json")
		      .body(map)
		.when()
		 .post()
		.then()
		      .statusCode(201)
		      .body("SuccessCode", equalTo("OPERATION_SUCCESS"))
		      .body("Message", equalTo("Operation completed successfully"));
	}

}
