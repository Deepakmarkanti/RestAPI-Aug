package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidents {
	@Test
	public void getAllIncidents() {
		// Step 1: Get URI/Endpoint
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// Step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
		// Step 3: Request Type (use Get Method)
		Response response = RestAssured.get();//  (ctrl+2) and l
		//ClassName obj = new ClassName();
		//obj.methodName();
		//or
		//ClassName.methodName();
		// Step 4: Validate response Code(200)
		System.out.println(response.getStatusCode());
		// Step 5: Validate formate 
		System.out.println(response.getContentType());
		// step 6: Print the Response 
		response.prettyPrint();

	}
	
	
	

}
