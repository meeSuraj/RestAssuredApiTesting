package session4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CheckforValidResponse {
//	https://reqres.in/api/users/2
		@Test
		public void GetSingleUser() {
		RestAssured.baseURI="https://reqres.in/api/users/2";
		
		//get request specification of the request
		RequestSpecification requestSpec=RestAssured.given();
		
		//call get method
		Response response=requestSpec.get();
		
		//gets response code
		int statusCode=response.getStatusCode();
		
		//validate actualstatuscode with expected
		Assert.assertEquals(statusCode, 200,"Correct status code received");
		
		String statusLine=response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK","Incorrect status line received");
	}
}
//status  line- protocol, status code, string