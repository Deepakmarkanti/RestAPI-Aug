package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyString {
	@Test
	public void createIncidentWithBodyString() {
		// Step 1: Get URI/Endpoint
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// Step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
		// Step 3: Request Type (use Get Method)
		Response response = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.queryParam("sysparm_fields", "sys_id,number,category,short_description")
		.body("{\"short_description\" : \"Post from Rest Assured\",\"category\" : \"Hardware\"}")
		.post();

		
//		contentType() -> Given InputData (post with body) request Input datatype
//		accept()      -> Request OutputData (response)

		// Step 4: Validate response Code(200)
		System.out.println(response.getStatusCode());
		// Step 5: Validate formate 
		System.out.println(response.getContentType());
		// step 6: Print the Response 
		response.prettyPrint();

	}




}
