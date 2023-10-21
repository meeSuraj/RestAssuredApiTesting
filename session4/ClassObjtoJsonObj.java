package session4;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class ClassObjtoJsonObj {
@Test
	public void createuser() {
		RequestSpecification res=RestAssured.given();
		res.baseUri("https://reqres.in/api/users");
		res.basePath("/api/users");
		
		//request body	
		JSONObject jsonData=new JSONObject();
		jsonData.put("name", "Rahul");
		jsonData.put("job", "Devops");
		
		//perform post request
		Response response=
		res.contentType(ContentType.JSON).
		body(jsonData.toJSONString()).
		post();
		
		ResponseBody responsebody=response.getBody();
		//deserialize responsebody ie JSON response body to class object
		Deserialize responseClass= responsebody.as(Deserialize.class);
		Assert.assertEquals(responseClass.name, "Rahul");
		Assert.assertEquals(responseClass.job, "Devops");
	}
}
