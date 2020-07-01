package ApiTest;

import org.testng.annotations.Test;

import Files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GoogleMapsApi {

public static void main(String[] args)
{
	//Add
	//RestAssured.baseURI ="https://rahulshettyacademy.com";
	RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType("application/json").addQueryParam("key", "qaclick123").build();
	ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();
	String addresponse = given().log().all().spec(req)
	.body(PayLoad.addPlace())
	.when().post("maps/api/place/add/json")
	.then().spec(res).extract().response().asString();
	
	System.out.println(addresponse);
	
	JsonPath js = new JsonPath(addresponse);
	String placeid = js.getString("place_id");

	//update
	String updateresponse = given().log().all().spec(req)
	.body("{\r\n" + 
			"\"place_id\":\""+placeid+"\",\r\n" + 
			"\"address\":\"70 Summer walk, USA\",\r\n" + 
			"\"key\":\"qaclick123\"\r\n" + 
			"}\r\n" + 
			"")
	.when().put("maps/api/place/update/json")
	.then().spec(res).extract().response().asString();
	
	System.out.println(updateresponse);
	
	//JsonPath js1 = new JsonPath(updateresponse);
	String newadress = "70 Summer walk, USA";
	System.out.println(newadress);
	//get
	String getresponse = given().log().all().spec(req).queryParam("place_id", placeid)
			.when().get("maps/api/place/get/json")
			.then().spec(res).body("address", equalTo(newadress)).extract().response().asString();
			
			System.out.println(getresponse);
			
		//delete
			
			String deleteresponse = given().log().all().spec(req)
					.body("{\r\n" + 
							"    \"place_id\":\""+placeid+"\"\r\n" + 
							"}\r\n" + 
							"")
					.when().delete("maps/api/place/delete/json")
					.then().spec(res).extract().response().asString();
					
					System.out.println(deleteresponse);

}
}
