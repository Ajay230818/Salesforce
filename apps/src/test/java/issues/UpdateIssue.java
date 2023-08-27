package issues;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateIssue extends BaseClass {
    
	@Test(dependsOnMethods ="issues.CreateIssue.create")   
	//packagename.classname.methodname
	public void update() {
		
		
		File fileName= new File("./src/test/resources/updateissue.json");
		
		//Initiate Request
		
		Response response = RestAssured.given()
		.contentType("application/json")
		.when()
		.body(fileName)
		.put("/issue/"+Issue_ID);
		
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		System.out.println("Status Code for Update----------"+statusCode);
		
		
	}
}
