package restAssured;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest {
//https://reqres.in/api/users/2
	
	@Test
	void testcase01() {
		Response res=RestAssured.get("https://reqres.in/api/users/2");
		//System.out.println(res);
		System.out.println(res.asString());
		System.out.println("status code is :"+ res.getStatusCode());
	}
}
