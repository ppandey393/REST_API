package httpMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OlderWay {
  @Test
  public void singleUserGetRequest() {
	  
	  Response response = RestAssured.get("https://www.google.com/");
	  System.out.println(response.statusCode());
	  System.out.println(response.getStatusLine());
	  System.out.println(response.getTime());
	  
	  int actualcode = response.getStatusCode();
	  
	  Assert.assertEquals(actualcode, 200, "Assertfail: Status code is not matching");
	  System.out.println("Assert Pass: Status Code matched with 200");
	  
	/*  Assert.assertEquals(actualcode, 201, "Assertfail: Status code is not matching");
	  System.out.println("Assert Pass: Status Code matched with 200");*/
	  	  
	  
  }
}
