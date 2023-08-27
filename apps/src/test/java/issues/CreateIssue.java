package issues;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.text.MatchesPattern;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIssue extends BaseClass{
	
	@Test
	public void create() {
		
		
		// Initiate request
		
		RequestSpecification contentType = RestAssured.given()
		.contentType("application/json");
		
		Response response = RestAssured.given()
		.contentType("application/json")
		.when()
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\": {\r\n"
				+ "            \"key\": \"TES\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"create issue in RA project\",\r\n"
				+ "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "            \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "}")
		.post("/issue/");
		
		//response.prettyPrint();
		
		response.then().assertThat().statusCode(201);
	
		// Extract Sys_id
		
		Issue_ID= response.jsonPath().get("id");
		System.out.println("issue ID -----"+Issue_ID);
		
		
		
		
		
	}

}
