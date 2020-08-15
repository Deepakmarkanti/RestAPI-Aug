package basic;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithBodyDP {

	@DataProvider(name="Json")
	public String[] getData() {	       //size of Row 		size of column(Data)  
		String[] filesPath = new String[2];
		//first row
		filesPath[0]  = "./data/JsonFile1.json";
		// sec row
		filesPath[1]  = "./data/JsonFile2.json";
		return filesPath;
	}

	@Test(dataProvider="Json")
	public void createIncidentWithBodyDP(String file) {
		// Step 1: Get URI/Endpoint
		RestAssured.baseURI = "https://dev53783.service-now.com/api/now/table/incident";
		// Step 2: Authorization
		RestAssured.authentication = RestAssured.basic("admin","Tuna@123");
		// Step 3: Request Type (use Get Method)

		File jsonFile = new File(file);

		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.queryParam("sysparm_fields", "sys_id,number,category,short_description")
				.body(jsonFile)
				.post();


		//		contentType() -> Given InputData (post with body) request Input datatype
		//		accept()      -> Request OutputData (response)

		// Step 4: Validate response Code(200)
		System.out.println(response.getStatusCode());
		// Step 5: Validate formate 
		System.out.println(response.getContentType());
		// step 6: Print the Response 
		response.prettyPrint();

	}




}
