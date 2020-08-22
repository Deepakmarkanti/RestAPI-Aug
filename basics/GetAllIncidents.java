package basics;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	@Test
	public void getIncidents() {
		//set up endpoint
		RestAssured.baseURI = "https://dev68594.service-now.com/api/now/table/incident";
		
		//set up authentication
		RestAssured.authentication = RestAssured.basic("admin", "India@123");
		
		//place get request
		Response response = RestAssured
							.given()
							.queryParam("sysparm_limit", "10")
							.when()
							.get();
		
		System.out.println(response.getStatusCode());
		
		//response.prettyPrint();
		
		JsonPath jsonPath = response.jsonPath();
		
		List<String> list = jsonPath.getList("result.number");
		
		for (String number : list) {
			
			System.out.println(number);
			
		}

	}

}
