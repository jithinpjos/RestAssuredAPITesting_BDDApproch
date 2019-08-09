package RestAssuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC003_PUT_Request {
	
	public static HashMap map=new HashMap();
			String EmployeeID="74815";
	@BeforeClass
	public void putData() {
		map.put("name", Utility.RandomFirstName());
		map.put("salary", Utility.RandomSalary());
		map.put("age", Utility.RandomAge());
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+EmployeeID;
	}
	
    @Test
    public void putTest() {
    	given()
    	     .contentType("application/json")
    	     .body(map)
    	     
    	.when()
    	      .put()
    	      
    	.then()
    	     .statusCode(200)
    	     .log().all();
    }
}
