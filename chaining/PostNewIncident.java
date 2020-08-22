package chaining;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostNewIncident extends BaseClass {

	@Test
	public void postNewIncident() {
		
		// place get request
		Response response = RestAssured.given().contentType(ContentType.JSON).when().post();

		System.out.println(response.getStatusCode());

	//	response.prettyPrint();

		JsonPath jsonPath = response.jsonPath();

		sys_id = jsonPath.get("result.sys_id");
		System.out.println(sys_id);

	}

}
