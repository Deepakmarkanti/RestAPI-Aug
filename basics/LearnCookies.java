package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LearnCookies {

	@Test
	public void incidents() {
		// set up endpoint
		RestAssured.baseURI = "https://dev68594.service-now.com/api/now/table/incident";

		// place get request
		Response response = RestAssured
							.given()
							.auth()
							.basic("admin", "India@123")
							.contentType(ContentType.JSON)
							.when()
							.post();

		System.out.println(response.getStatusCode());

		// response.prettyPrint();
		
		  JsonPath jsonPath = response.jsonPath();
		  
		  String sys_id = jsonPath.get("result.sys_id"); 
		  System.out.println(sys_id);
		  
		  String cookie = response.getCookie("JSESSIONID");
		  System.out.println(cookie);
		  
		/*
		 * Map<String, String> cookies = response.getCookies();
		 * 
		 * Set<Entry<String, String>> entrySet = cookies.entrySet();
		 * 
		 * for (Entry<String, String> eachEntry : entrySet) {
		 * 
		 * System.out.println(eachEntry.getKey()+"-->"+eachEntry.getValue());
		 * 
		 * }
		 */
		  
		  
		  Response response2 = RestAssured
				  				.given()
				  				.cookie("JSESSIONID",cookie)
				  				.get();
		  
		  String incidentNumber = (String)response2.jsonPath().getList("result.number").get(0);
		  System.out.println(incidentNumber);
		  
		  
		  
		  
		  
		  
		 
	}

}
