package issues;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident extends BaseClass {

	@Test(dependsOnMethods ="issues.UpdateIssue.update") 
	public void delete() {
		
		
		Response response = RestAssured.delete("/issue/"+Issue_ID);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code for Delete----------"+statusCode);
		
	
	}
}
