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

public class CreateNewJiraIssue extends BaseClass{

	@Test
	public void createNewIssue() {
		// set up endpoint
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue";

		// set up authentication
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "enRsqhIt1JdnwwFwrnq6F9DC");
		
		
		List<Header> listHeader = new ArrayList<Header>();
		
		listHeader.add(new Header("Content-Type","application/json"));
	//	listHeader.add(new Header("X-Atlassian-Token","no-check"));
		
		Headers headers = new Headers(listHeader);
		
		//File file = new File("./data/webex_issue.jpg");
		

		// place get request
		Response response = RestAssured
							.given()
							.headers(headers)
							.body("{\r\n" + 
									"    \"fields\": {\r\n" + 
									"    \"project\":\r\n" + 
									"                {\r\n" + 
									"                    \"key\": \"RA\"\r\n" + 
									"                },\r\n" + 
									"    \"summary\": \"create issue in RA project\",\r\n" + 
									"    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
									"    \"issuetype\": {\r\n" + 
									"                    \"name\": \"Story\"\r\n" + 
									"                }\r\n" + 
									"    }\r\n" + 
									"}")
							.when()
							.post();

		System.out.println(response.getStatusCode());

		 response.prettyPrint();
		
		  JsonPath jsonPath = response.jsonPath();
		  
		  issue_id = jsonPath.get("id"); 
		  System.out.println(issue_id);
		 
	}

}
