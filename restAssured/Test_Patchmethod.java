package restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_Patchmethod {
	@Test
	public void test05() {
	
	JSONObject jsonData=new JSONObject();
	jsonData.put("name", "Tanushree");
	jsonData.put("job", "SalesAdmin ");
	RestAssured.baseURI="https://reqres.in/api/users/660";
	RestAssured.given().
	header("Content-Type","application/json").
	contentType(ContentType.JSON).
	body(jsonData.toJSONString()).
	when().
	patch().
	then().
	statusCode(200).log().all();
	}
}