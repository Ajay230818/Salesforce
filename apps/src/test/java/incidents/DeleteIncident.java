package incidents;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIncident extends BaseClass {

	@Test(dependsOnMethods ="incidents.UpdateIncident.update") 
	public void delete() {
		
		
		Response response = RestAssured.delete("/incident/"+sys_ID);
		int statusCode = response.getStatusCode();
		System.out.println("Status Code for Delete----------"+statusCode);
		
	
	}
}
