package week3.assignments;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class GetAllIssues extends BaseClass{

	@Test(dependsOnMethods = "week3.assignments.CreateNewJiraIssue.createNewIssue")
	public void getJiraIssues() {
		// set up endpoint
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/"+issue_id;

		// set up authentication
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "enRsqhIt1JdnwwFwrnq6F9DC");
		
		
		List<Header> listHeader = new ArrayList<Header>();
		
		listHeader.add(new Header("Accept","application/json"));
	//	listHeader.add(new Header("X-Atlassian-Token","no-check"));
		
		Headers headers = new Headers(listHeader);
		
		//File file = new File("./data/webex_issue.jpg");
		

		// place get request
		Response response = RestAssured
							.given()
							.headers(headers)
							.when()
							.get()
							.then()
							.assertThat()
							.body("fields.issuetype.description",containsString("Functionality") )
							.extract()
							.response();

		System.out.println(response.getStatusCode());

		 response.prettyPrint();
		
		/*
		 * JsonPath jsonPath = response.jsonPath();
		 * 
		 * issue_id = jsonPath.get("id"); System.out.println(issue_id);
		 */
		 
	}

}
