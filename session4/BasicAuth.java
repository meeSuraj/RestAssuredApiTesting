package session4;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


//http://postman-echo.com/basic-auth
public class BasicAuth {
	@Test(enabled = false)
	public void bauth() {
		RequestSpecification reqspec=RestAssured.given();

		//specify URL
		reqspec.baseUri("http://postman-echo.com");
		reqspec.basePath("/basic-auth");

		//Response response=reqspec.auth().basic("postman", "password").get();
		Response responses=reqspec.auth().preemptive().basic("postman", "password").get();
		//print status line
		System.out.println("Response status: " + responses.statusLine());
	}
	@Test (enabled = false)
	public void Digestauth() {
		RequestSpecification reqspec=RestAssured.given();
		//https://httpbin.org/digest-auth/undefined/suraj/suraj

		//specify URL
		reqspec.baseUri("http://httpbin.org");
		reqspec.basePath("/digest-auth/undefined/suraj/suraj");

		//Response response=reqspec.get();
		Response responsess=reqspec.auth().digest("suraj", "suraj").get();
		//print status line
		Assert.assertEquals(responsess.getStatusCode(), 201);
		System.out.println("Digest Auth Response status: " + responsess.statusLine());
		System.out.println("Digest Auth Response body: " + responsess.body().asString());
	}

	//Bearer token authentication
	@Test (enabled=false)
	public void BearerToken() {
		RequestSpecification reqspec=RestAssured.given();
		//https://gorest.co.in/public/v2/users

		//specify URL
		reqspec.baseUri("https://gorest.co.in/rest-console");
		reqspec.basePath("/public/v2/users");
		JSONObject payload=new JSONObject();
		payload.put("name","surajdss");
		payload.put("gender","male");
		payload.put("email","surajdss@gmail.com");
		payload.put("Status","Inactive");

		String authToken="Bearer 527beb82b34be07cbb43bcec43689afe3e55a9665641ac7e8ba1ae6ed3532d6f";
		reqspec.headers("Authorization", authToken).
		contentType(ContentType.JSON).
		body(payload.toJSONString());

		Response response=reqspec.post();
		Assert.assertEquals(response.getStatusCode(), 201,"check statuscode");
		System.out.println("Response status: " + response.statusLine());
		System.out.println("Response body: " + response.body().asString());
	}
	@Test
	public void APIkey() {
		//https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={API key}
		RequestSpecification reqspec=RestAssured.given();

		//specify req spec
		reqspec.queryParam("q", "delhi").queryParam("appid", "25db0dcefc81cf25556c93887cb25415");
		Response response=reqspec.get();
		//validate status code
		Assert.assertEquals(response.getStatusCode(), 200,"check statuscode");
		//print status line and resopnse body
		System.out.println("Response status: " + response.statusLine());
		System.out.println("Response body: " + response.body().asString());
	}
}
