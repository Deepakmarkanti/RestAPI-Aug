package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncidents {
	@Test
	public void deleteIncidents() {
		// Step 1: Get URI/Endpoint
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident/";
		// Step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
		// Step 3: Request Type (use Get Method)
		Response response = RestAssured
		.given()
		.log()
		.all()
		.pathParam("sys_id", "8d6246c7c0a80164012fb063cecd4ace")
		.delete("{sys_id}");
		
		
		// Step 4: Validate response Code(200)
		System.out.println(response.getStatusCode());
		// Step 5: Validate formate 
		System.out.println(response.getContentType());
		// step 6: Print the Response 
		response.prettyPrint();

	}
	
	
	

}
