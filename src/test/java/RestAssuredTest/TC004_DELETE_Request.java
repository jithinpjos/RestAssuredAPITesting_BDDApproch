package RestAssuredTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC004_DELETE_Request {
	
	@Test
	public void DeleteRequest() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/74511";
		
		Response Response=
		given()
		.when()
		 		.delete()
 		.then()
 				.statusCode(200)
 				.statusLine("HTTP/1.1 200 OK")
 				.log().all()
 				.extract().response();
		String jsonToString=Response.asString();
		Assert.assertEquals(jsonToString.contains("successfully! deleted Records"),true);
		
	}

}
