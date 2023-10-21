package restAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_Putmethod {
@Test
	public void test04() {
		
	JSONObject jsonData=new JSONObject();
	jsonData.put("name", "Suresh");
	jsonData.put("job", "Admin ");
	RestAssured.baseURI="https://reqres.in/api/users/660";
	RestAssured.given().header("Content-Type","application/json").
	contentType(ContentType.JSON).
	body(jsonData.toJSONString()).
	when().put().
	then().statusCode(200).log().all();
	}

}
