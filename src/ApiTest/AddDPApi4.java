package ApiTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddDPApi4 {
@Test
public void addBook() throws IOException
{
	RestAssured.baseURI ="http://216.10.245.166";
	String addresponse = given().log().all().header("Content-Type","application/json")
	.body(PayLoad.generateStringFromResponse("D:\\Jars\\data.json"))
	.when().post("/Library/Addbook.php")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(addresponse);
	
	JsonPath js = new JsonPath(addresponse);
    String id = js.getString("ID");
}
}
