package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidentsWithParam {
	@Test
	public void getAllIncidents() {
		// Step 1: Get URI/Endpoint
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// Step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
		// Step 3: Request Type (use Get Method)
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "sys_id,number,category")
				.queryParam("category", "Software")
				.get();
		// Step 4: Validate response Code(200)
		System.out.println(response.getStatusCode());
		// Step 5: Validate formate 
		System.out.println(response.getContentType());
		// step 6: Print the Response 
		//response.prettyPrint();

	}
	
	
	

}
