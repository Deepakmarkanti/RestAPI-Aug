package basics;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;


import static org.hamcrest.Matchers.*;

public class LearnAssertion {

	@Test
	public void getIncidents() {
		// set up endpoint
		RestAssured.baseURI = "https://dev68594.service-now.com/api/now/table/incident";

		// set up authentication
		RestAssured.authentication = RestAssured.basic("admin", "India@123");
			
		// place get request
							Response response = RestAssured
							.given()
							.contentType(ContentType.JSON)
							.body("{\"short_description\":\"created from RA\"}")
							.when()
							.post()
							.then()
							.assertThat()
							.statusCode(201)
							.body("result.short_description",containsString("created"))
							.body("result.short_description",equalTo("created from RA"))
							.extract()
							.response();
							

	//	int statusCode = response.getStatusCode();

		 response.prettyPrint();
		
	//	Assert.assertEquals(statusCode, 200);
		
		 
		/*
		 * if(statusCode==200) { System.out.println("matching"); }else {
		 * System.out.println("not matching"); }
		 */
		 
		
		  JsonPath jsonPath = response.jsonPath();
		  
		  String sys_id = jsonPath.get("result.sys_id"); 
		  System.out.println(sys_id);
		 
	}

}
