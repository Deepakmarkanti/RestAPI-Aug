package basics;

import java.util.ArrayList;
import java.util.Arrays;
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

public class AssertionForGet {

	@Test
	public void getIncidents() {
		// set up endpoint
		RestAssured.baseURI = "https://dev68594.service-now.com/api/now/table/incident";

		// set up authentication
		RestAssured.authentication = RestAssured.basic("admin", "India@123");
			
		// place get request
							Response response = RestAssured
							.given()
							.accept(ContentType.JSON)
							.queryParam("sys_id", "56dd2a33db22101093ecf53a299619ab")
							.get()
							.then()
							.assertThat()
							.statusCode(200)
							.body("result[0].short_description",containsString("RestAssured"))
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
		  
		 List<String> list = jsonPath.getList("result.sys_id"); 
		  System.out.println(list.get(0));
		 
	}

}
