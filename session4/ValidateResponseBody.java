package session4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class ValidateResponseBody {

	@Test

	public void UserListResponseBody() {
		//Get RequestSpecification reference
		RequestSpecification requestSpec=RestAssured.given();

		//specify Base URI
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("api/users?page=2");

		//create get request
		Response response=requestSpec.get();

		//read response body
		ResponseBody responsebody=response.getBody();
		String responseString=responsebody.asString();
		System.out.println("Response body " + responseString);
		
		//check for presence of George in response body
		Assert.assertEquals(responseString.contains("George"), true,"Check for value George");
		
		//get json path view of response body
		JsonPath jsonpathView=responsebody.jsonPath();
		//x.data[4].first_name
		String Firstname=jsonpathView.get("data[0].first_name");
		Assert.assertEquals(Firstname, "George", "Check for value George");
		System.out.println("email address: " + jsonpathView.get("data[2].last_name"));
	}

}
