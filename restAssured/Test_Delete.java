package restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_Delete {
	@Test
	public void test06() {
	
	RestAssured.baseURI="https://reqres.in/api/users/660";
	RestAssured.given().
	when().
	delete().
	then().
	log().all().
	statusCode(204);
	}
}
