package steps;

import java.io.File;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProjectCommonMethos {
	
	public static RequestSpecification requestSpec;
	
	public static Response response;
	
	@Given("setup the base URI for (.*) api")
	public void setupBaseUri(String table_name) {
		RestAssured.baseURI ="https://dev68594.service-now.com/api/now/table/"+table_name;

	}
	
	@Given("setup the basic authentication with valid credentials")
	public void setupBasicAuthentication() {
		RestAssured.authentication = RestAssured.basic("admin", "India@123");

	}
	
	@And("pass the data file (.*) in the body")
	public void passBodyData(String fileName) {
		
		File file = new File("./data/"+fileName);
		
		requestSpec = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body(file);

	}
	
	@When("place the post request")
	public void postRequest() {
		response = requestSpec.post();

	}
	
	@Then("verify the status code as (.*)")
	public void verifyStatusCode(int statusCode) {
		response.then().assertThat().statusCode(statusCode);
		System.out.println(response.getStatusCode());

	}
	
	@When("place the get request")
	public void getRequest() {
		response = RestAssured.get();

	}

}
