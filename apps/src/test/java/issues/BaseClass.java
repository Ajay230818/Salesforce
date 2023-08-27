package issues;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BaseClass {
public static String Issue_ID;
	
	@BeforeMethod
	public void setUp() {
		// Set Endpoint
	RestAssured.baseURI="https://testjirafeb2023.atlassian.net/rest/api/2";
				
				// Set Authentication
	RestAssured.authentication=RestAssured.preemptive().basic("Feb2023restAPI@gmail.com", "ATATT3xFfGF0d39TsozfFQWR0Hvr0UfPqKKtyFJxQvnaGGtSvez8FvOvhfzSTapOBEUGx0ZAdIbWfM5tjeU8rFw7Rh72pbanmBdYhtysnC3yH89HMn-lXz9PTGKVKtWFV2vp6GyZ_75P27LqLCAbHxqOjYds1SNn5oFZQFDi3ufeUI3cJwdCy20=5543D93F");
				
	}
}
