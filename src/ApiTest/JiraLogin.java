package ApiTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class JiraLogin {

public static void main(String[] args)
{
	RestAssured.baseURI ="http://localhost:8081";
	
	//Login
	SessionFilter s =new SessionFilter();
	String response=given().relaxedHTTPSValidation().log().all().header("Content-Type","application/json").body("{ \"username\": \"aneesa\", \"password\": \"Jira12345\" }")
	.filter(s).when().post("/rest/auth/1/session").then().assertThat().statusCode(200).extract().response().asString();
	//Add
	
	String createresponse = given().relaxedHTTPSValidation().log().all().header("Content-Type","application/json").header("Cookie","JSESSIONID="+"024856208E3B25AD8B9F00E5516A3807")
	.body(PayLoad.createIssue())
	.filter(s).when().post("/rest/api/2/issue/")
	.then().assertThat().statusCode(201).extract().response().asString();
	
	System.out.println(createresponse);
	//add comment
	
	String addComment =given().relaxedHTTPSValidation().log().all().header("Content-Type","application/json").pathParam("id", "10101").body(PayLoad.addComment())
			.filter(s).when().post("/rest/api/2/issue/{id}/comment").then().assertThat().statusCode(201).extract().response().asString();
	System.out.println(addComment);
	JsonPath js = new JsonPath(addComment);
	String commentidexpected = js.getString("id");
	String message =js.getString("body");
	
	//add attachment
	
		String addAttachment =given().relaxedHTTPSValidation().log().all().header("X-Atlassian-Token","no-check").header("Content-Type","multipart/form-data").pathParam("id", "10101").multiPart("file", new File("jira.txt"))
				.filter(s).when().post("/rest/api/2/issue/{id}/attachments").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(addAttachment);
		
		//get Issue Details
		
		String getDetails =given().relaxedHTTPSValidation().log().all().pathParam("id", "10101").queryParam("fields", "comment")
				.filter(s).when().get("/rest/api/2/issue/{id}").then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(getDetails);	
		
		
		
	JsonPath js1 = new JsonPath(getDetails);
	int commentscount= js1.get("fields.comment.comments.size()");
	for(int i=0;i<commentscount;i++)
	{
		String commentid=js1.get("fields.comment.comments["+i+"].id").toString();
			if(commentid.equalsIgnoreCase(commentidexpected))
			{
				String expectedmessage =js1.get("fields.comment.comments["+i+"].body").toString();
				Assert.assertEquals(message, expectedmessage);
			}
			
			
	}

	
}
}
