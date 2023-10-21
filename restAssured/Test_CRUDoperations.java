package restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_CRUDoperations {
	@Test
	public void test01() {
		Response res=RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response code is "+res.getStatusCode());
		System.out.println("Response body is "+res.getBody().asString());
		System.out.println("Response time is "+res.getTime());
		System.out.println("Get header is "+res.getHeader("Content-Type"));
		//validate status code
		int expectedStatuscode=200;
		int statuscode=res.getStatusCode();
		Assert.assertEquals(expectedStatuscode, statuscode);
	} 
	@Test
	public void Test2() {
		//given, when, then
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.given().queryParam("page",2).when().get().then().statusCode(200);
	}
}
