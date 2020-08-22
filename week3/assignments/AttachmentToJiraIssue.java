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

public class AttachmentToJiraIssue {

	@Test
	public void createChangeRequest() {
		// set up endpoint
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/3/issue/RA-42/attachments";

		// set up authentication
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "enRsqhIt1JdnwwFwrnq6F9DC");
		
		
		List<Header> listHeader = new ArrayList<Header>();
		
		listHeader.add(new Header("Content-Type","multipart/form-data"));
		listHeader.add(new Header("X-Atlassian-Token","no-check"));
		
		Headers headers = new Headers(listHeader);
		
		File file = new File("./data/webex_issue.jpg");
		

		// place get request
		Response response = RestAssured
							.given()
							.headers(headers)
							.multiPart(file)
							.when()
							.post();

		System.out.println(response.getStatusCode());

		 response.prettyPrint();
		
		 /* JsonPath jsonPath = response.jsonPath();
		  
		  String sys_id = jsonPath.get("result.sys_id"); System.out.println(sys_id);*/
		 
	}

}
