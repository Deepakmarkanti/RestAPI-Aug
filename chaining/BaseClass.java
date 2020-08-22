package chaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BaseClass {

	public static String sys_id;
	

	@BeforeMethod
	public void preCondition() {
		// set up endpoint
		RestAssured.baseURI = "https://dev68594.service-now.com/api/now/table/incident";

		// set up authentication
		RestAssured.authentication = RestAssured.basic("admin", "India@123");

	}

}
