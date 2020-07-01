package ApiTest;

import org.testng.annotations.Test;

import Files.PayLoad;
import Pojo.AddPlace;
import Pojo.Location;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

public class SpecBuilder {

public static void main(String[] args)
{
	//Add
	RestAssured.baseURI ="https://rahulshettyacademy.com";
	AddPlace p=new AddPlace();
	p.setAccuracy(50);
	p.setAddress("29, side layout, cohen 09");
	p.setLanguage("French-IN");
	p.setPhone_number("(+91) 983 893 3937");
	p.setWebsite("https://rahulshettyacademy.com");
	p.setName("Frontline house");
	
	List<String> myList =new ArrayList<String>();
	myList.add("asds");
	myList.add("asdadas");
	myList.add("asdasdwedwewew");
	p.setTypes(myList);
	Location l =new Location();
	l.setLat(-34.23234);
	l.setLng(98.656676);
	p.setLocation(l);
	RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType("application/json").addQueryParam("key", "qaclick123").build();
	ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType("application/json").build();
	String addresponse = given().log().all().spec(req)
	.body(p)
	.when().post("maps/api/place/add/json")
	.then().spec(res).extract().response().asString();
	
	System.out.println(addresponse);
}
}
