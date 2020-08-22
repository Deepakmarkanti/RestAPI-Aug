package chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteIncident extends BaseClass{

	@Test(dependsOnMethods="chaining.PostNewIncident.postNewIncident")
	public void deleteIncident() {
		

		// place get request
		Response response = RestAssured
							.given()
							.log()
							.all()
							.pathParam("sys_id", sys_id)
							.when()
							.delete("{sys_id}");

		System.out.println(response.getStatusCode());

		

	}

}
