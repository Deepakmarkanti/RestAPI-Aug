package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident {

	@Test
	public void getIncidents() {
		// set up endpoint
		RestAssured.baseURI = "https://dev68594.service-now.com/api/now/table/incident";

		// set up authentication
		RestAssured.authentication = RestAssured.basic("admin", "India@123");

		// place get request
		Response response = RestAssured
							.given()
							.pathParam("sys_id", "1e504097dba6101093ecf53a299619aa")
							.when()
							.delete("{sys_id}");

		System.out.println(response.getStatusCode());

		

	}

}
