package session4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//https://reqres.in/api/users?page=2
public class ValidateQueryParameter {
	@Test
	public void filterData() 
	{
		//get request specification
		RequestSpecification reqspec= RestAssured.given();
		
		//specify URL
		reqspec.baseUri("https://reqres.in");
		reqspec.basePath("/api/users");
		reqspec.queryParam("page", 2).queryParam("id", 10);
		
		//perfrom get request
		Response response=reqspec.get();
		//read response body
		String resbody=response.getBody().asString();
		//print response body
		System.out.println("Response body "+ resbody);
		//get json view of response body
		JsonPath jsonpathview=response.jsonPath();
		
		//get firstname
		String Firstname=jsonpathview.get("data.first_name");
		
		Assert.assertEquals(Firstname, "Byron", "Verify firstname");
	}
}
