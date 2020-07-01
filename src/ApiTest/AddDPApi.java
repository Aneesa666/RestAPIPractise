package ApiTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddDPApi {
@Test(dataProvider ="getData")
public void addBook(String isbn,String aisle)
{
	RestAssured.baseURI ="http://216.10.245.166";
	String addresponse = given().log().all().header("Content-Type","application/json")
	.body(PayLoad.addBook(isbn,aisle))
	.when().post("/Library/Addbook.php")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	System.out.println(addresponse);
	
	JsonPath js = new JsonPath(addresponse);
    String id = js.getString("ID");
}


@DataProvider
public Object[][] getData()
{
	return new Object[][] {{"aasdas","32423"},{"dasdasd","423423"},{"3adasd","423423"}};
}
}
