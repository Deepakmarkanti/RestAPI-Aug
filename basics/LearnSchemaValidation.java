package basics;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class LearnSchemaValidation {

	@Test
	public void getIncidents() {
		// set up endpoint
		RestAssured.baseURI = "https://dev68594.service-now.com/api/now/table/incident";

		// set up authentication
		RestAssured.authentication = RestAssured.basic("admin", "India@123");
		
		
		List<Header> listHeader = new ArrayList<Header>();
		
		listHeader.add(new Header("Content-Type","application/json"));
		listHeader.add(new Header("Accept","application/xml"));
		
		Headers headers = new Headers(listHeader);
		
		
		

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
							//.body(matchesJsonSchemaInClasspath("schema.json"))
							.extract()
							.response();

		System.out.println(response.getStatusCode());

		 response.prettyPrint();
		/*
		 * JsonPath jsonPath = response.jsonPath();
		 * 
		 * String sys_id = jsonPath.get("result.sys_id"); System.out.println(sys_id);
		 */
	}

}
