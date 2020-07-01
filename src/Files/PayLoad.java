package Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayLoad {

	public static String addPlace()
	{
		return "{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontline house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, siddddde qweqweqweqw, asasasaasa 12sds23\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}\r\n" + 
				"";
	}
public static String addBook(String isbn,String aisle)
{
	return "{\r\n" + 
			"\r\n" + 
			"\"name\":\"Learn Appium Automation with Java\",\r\n" + 
			"\"isbn\":\""+isbn+"\",\r\n" + 
			"\"aisle\":\""+aisle+"\",\r\n" + 
			"\"author\":\"John foe\"\r\n" + 
			"}\r\n" + 
			"";
}

public static String generateStringFromResponse(String path) throws IOException
{
	return new String(Files.readAllBytes(Paths.get(path)));
}

public static String coursePrice()
{
	return "{\r\n" + 
			"\r\n" + 
			"\"dashboard\": {\r\n" + 
			"\r\n" + 
			"\"purchaseAmount\": 910,\r\n" + 
			"\r\n" + 
			"\"website\": \"rahulshettyacademy.com\"\r\n" + 
			"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"\"courses\": [\r\n" + 
			"\r\n" + 
			"{\r\n" + 
			"\r\n" + 
			"\"title\": \"Selenium Python\",\r\n" + 
			"\r\n" + 
			"\"price\": 50,\r\n" + 
			"\r\n" + 
			"\"copies\": 6\r\n" + 
			"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"{\r\n" + 
			"\r\n" + 
			"\"title\": \"Cypress\",\r\n" + 
			"\r\n" + 
			"\"price\": 40,\r\n" + 
			"\r\n" + 
			"\"copies\": 4\r\n" + 
			"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"{\r\n" + 
			"\r\n" + 
			"\"title\": \"RPA\",\r\n" + 
			"\r\n" + 
			"\"price\": 45,\r\n" + 
			"\r\n" + 
			"\"copies\": 10\r\n" + 
			"\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"]\r\n" + 
			"\r\n" + 
			"}";
}

public static String createIssue()
{
	return "{\r\n" + 
			"    \"fields\": {\r\n" + 
			"       \"project\":\r\n" + 
			"       {\r\n" + 
			"          \"id\": \"10100\"\r\n" + 
			"       },\r\n" + 
			"       \"summary\": \"My New Issue for adding comments and attachmemts.\",\r\n" + 
			"       \"description\": \"Creating an issue using ids for projects and issue types using the REST API\",\r\n" + 
			"       \"issuetype\": {\r\n" + 
			"          \"name\": \"Bug\"\r\n" + 
			"       }\r\n" + 
			"   }\r\n" + 
			"}";
}
public static String addComment()
{
	return "{\r\n" + 
			"    \"body\": \"This is my latest Comment.\",\r\n" + 
			"    \"visibility\": {\r\n" + 
			"        \"type\": \"role\",\r\n" + 
			"        \"value\": \"Administrators\"\r\n" + 
			"    }\r\n" + 
			"}";
}
}
