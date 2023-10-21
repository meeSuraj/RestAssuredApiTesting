package session4;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckforValidatableResponse {
	@Test
	public void GetSingleUser() {
	RestAssured.baseURI="https://reqres.in/api/users/2";
	
	//get request specification of the request
	RequestSpecification requestSpec=RestAssured.given();
	
	//call get method
	Response response=requestSpec.get();
	ValidatableResponse validateRes=response.then();
	
	//status code
	validateRes.statusCode(200);
	System.out.println("second validation");
	
	//status line
	validateRes.statusLine("HTTP/1.1 200 OK");
}
	
	@Test
	
	public void GetSingleuser_BDDStyle() {
		
		RestAssured.given().when().get("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		statusLine("HTTP/1.1 200 OK");
	}
}