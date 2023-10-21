package session4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ValidateResponseHeader {
 
	@Test
	public void GetSingleUser() {
		
	RequestSpecification requestSpec= RestAssured.given();
	requestSpec.baseUri("https://reqres.in");
	requestSpec.basePath("/api/users/2");
	
	//Create Get request
	Response response= requestSpec.get();
	
	//validate response header
	String contentType=response.getHeader("Content-Type");
	String connection=response.getHeader("Connection");
	System.out.println("Content type " +contentType);
	System.out.println("Connection type " +connection);
	
	//Read all the response header attributes/keys and print their values
	Headers headersList=response.getHeaders();
	for(Header header:headersList) {
		
		System.out.println("Key : " + header.getName() + "Values : " +header.getValue());
	}

	//validate header content-type, expected value: application/json; charset=utf-8
	
	Assert.assertEquals(contentType, "application/json; charset=utf-8", "Header content type");
	
	
	
	}
}
