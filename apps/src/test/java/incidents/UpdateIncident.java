package incidents;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateIncident extends BaseClass {
    
	@Test(dependsOnMethods ="incidents.CreateIncident.create")   
	//packagename.classname.methodname
	public void update() {
		
		
		File fileName= new File("./src/test/resources/updateIncident.json");
		
		//Initiate Request
		
		Response response = RestAssured.given()
		.contentType("application/json")
		.when()
		.body(fileName)
		.put("/incident/"+sys_ID);
		
		response.prettyPrint();
		
		
	}
}
