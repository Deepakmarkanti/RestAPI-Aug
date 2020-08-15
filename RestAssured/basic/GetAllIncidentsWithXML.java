package basic;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidentsWithXML {
	@Test
	public void getAllIncidentsWithJson() {
		// Step 1: Get URI/Endpoint
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// Step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
		// Step 3: Request Type (use Get Method)
		Response response = RestAssured
				.given()
				.queryParam("sysparm_fields", "sys_id,number,category")
				.queryParam("category", "Software")
				//				.accept("application/xml")
				.accept(ContentType.XML)
				.get();
		// Step 4: Validate response Code(200)
		System.out.println(response.getStatusCode());
		// Step 5: Validate formate 
		System.out.println(response.getContentType());
		// step 6: Print the Response in json 
		//response.prettyPrint();

		//Convert response to XML 
		XmlPath xmlResponse = response.xmlPath();
		//Find Incident Count 
		List<Object> listOfNumber = xmlResponse.getList("response.result.sys_id");
		//listObj.size();
		System.out.println(listOfNumber.size());
		//Get First Incident
		System.out.println(listOfNumber.get(0));




		/*//Convert response to Json 
		JsonPath jsonResponse = response.jsonPath();
		//Find Incident Count 
		List<Object> listOfNumbers = jsonResponse.getList("result.number");
		//listObj.size();
		System.out.println(listOfNumbers.size());
		//Get First Incident
		System.out.println(listOfNumbers.get(0));*/

	}




}
