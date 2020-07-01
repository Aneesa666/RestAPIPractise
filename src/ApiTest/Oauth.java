package ApiTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Files.PayLoad;
import Pojo.Api;
import Pojo.GetCourse;
import Pojo.WebAutomation;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oauth {

public static void main(String[] args)
{
	//RestAssured.baseURI ="https://rahulshettyacademy.com/getCourse.php";
	//get Auth code

	/*System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	WebDriver driver =new ChromeDriver();
	driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");*/

//String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F1QEe3pYUockuQK1TS1IWqajRrHZ2G02LpRXWq2udC62E0qmrS0WK4rbiuupv2wWbc3Ctatf-YD_76CUO9eIYpCM&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=consent#";
String url ="https://rahulshettyacademy.com/getCourse.php?code=4%2F1QEX95aTFRBMyXeOy0u_0UBcnekF4BC_FW4c9c7Dy0UUrjQ-WH2hFVOGtg2hebOfckvJdF8c-GAb6p-mjxEB_po&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none#";
	String partialcode =url.split("code=")[1];
String code =partialcode.split("&scope")[0];
	System.out.println(code);
	//get access token
	String accesstokenresponse =given().urlEncodingEnabled(false).queryParam("code", code)
			.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
			.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
			.queryParam("grant_type", "authorization_code")
			.when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();
	System.out.println(accesstokenresponse);
	JsonPath js =new JsonPath(accesstokenresponse);
	String accesstoken = js.getString("access_token");
	System.out.println(accesstoken);
	//auth step
	GetCourse gc=given().queryParam("access_token", accesstoken).expect().defaultParser(Parser.JSON)
			.when()
			.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);
	System.out.println(gc.getLinkedIn());
	System.out.println(gc.getInstructor());
	System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
	List<Api> api =gc.getCourses().getApi();
	for(int j=0;j<api.size();j++)
	{
		if(api.get(j).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
				{
			System.out.println(api.get(j).getPrice());
				}
	}
	
	List<WebAutomation> webAutomation =gc.getCourses().getWebAutomation();
	ArrayList<String>a =new ArrayList<String>();
	for(int i=0;i<webAutomation.size();i++)
	{
		a.add(webAutomation.get(i).getCourseTitle());
	}
	String[] CourseTitle = {"Selenium Webdriver Java","Cypress","Protractor"};
	List<String> ExpectedResult =Arrays.asList(CourseTitle);
	Assert.assertTrue(a.equals(ExpectedResult));
}
}
