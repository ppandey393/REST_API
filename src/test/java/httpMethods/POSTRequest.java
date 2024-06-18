package httpMethods;

/*
POST==
Create resource on server
1. HashMap
2. POJO - plain old java object class [encapsulation: data+function]
		
*/

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class POSTRequest {
  @Test
  public void postWithHashMap() {
	  
	  
	  //Request Payload
	  HashMap<String,Object> data = new HashMap<String,Object>();
	  data.put("name", "John");
	  data.put("Job", "SDET");
	  
	  given()
	  		.contentType("application/json")
	  		.body(data)
	  .when()
	  		.post("https://reqres.in/api/users")
	  		
	  .then()
	  		.statusCode(201)
	  		.body("name", equalTo("John"))
	  		.log().body();
	  System.out.println("Data created successfully");
	  	  
  }
}
