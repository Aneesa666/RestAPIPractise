package ApiTest;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.PayLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddDPApi3 {
@Test
public void addBook() throws IOException
{
	
	JsonPath js = new JsonPath(PayLoad.generateStringFromResponse("D:\\Jars\\example.json"));
   int NoOfCourses= js.getInt("courses.size()");
   System.out.println(NoOfCourses);
   int purchaseamt =js.getInt("dashboard.purchaseAmount");
   System.out.println(purchaseamt);
   String firstTitle =js.get("courses[0].title");
   System.out.println(firstTitle);
  
   for(int i=0;i<NoOfCourses;i++)
   {
	  String title =js.get("courses["+i+"].title");
	  String price = js.get("courses["+i+"].price").toString();
	  System.out.println(title);
	  System.out.println(price);
   }
   for(int i=0;i<NoOfCourses;i++)
   {
	  if(js.get("courses["+i+"].title").equals("RPA"))
	  {
		  int copies =js.get("courses["+i+"].copies");
		  System.out.println(copies);
		  break;
	  }
	  
   }
   int sum=0;
   for(int i=0;i<NoOfCourses;i++)
   {
	   int copies =js.getInt("courses["+i+"].copies");
	   int price = js.get("courses["+i+"].price");
	   int purchaseAmount =copies * price;
	  sum+=purchaseAmount; 
   }
   Assert.assertEquals(sum, purchaseamt);
}
}
