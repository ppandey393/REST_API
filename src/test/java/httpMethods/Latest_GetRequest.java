package httpMethods;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/* given() - prerequisite
 * header/cookies/path/query param/request payload (resource data)/authentication
 * when() - send request
 * GET/POST/PUT/PATCH/DELETE
 * then() - validate response
 * status code/response payload/status msg/time/body/cookies
 
 *Methods ----
 *equalTo() - test equality
 *hasItems() - checks if all elements are present in a collection
 *contains() - checks if elements are in a collection and in strict order
 *
 */

public class Latest_GetRequest {
  @Test(priority=1)
  public void singleUserRequest() {
	  
	  //https://reqres.in/api/users/2
	  
	  given()
	  		
	  .when()
	  		.get("https://reqres.in/api/users/2")
	  
	  .then()
	  		.statusCode(200)
	  		.body("data.first_name", equalTo("Janet"))
	  		.body("data.email", equalTo("janet.weaver@reqres.in"))
	  		.log().all();
	  	  	System.out.println("Single user validation is done");
	}
    
  @Test(priority=2)
  public void listofUsers()
  {
	  
	  given()
	  
	  .when()
	  .get("https://reqres.in/api/users?page=2")
	  
	  .then()
	  .statusCode(200)
	  .body("page", equalTo(2))
	  .body("data.id[2]", equalTo(9))
	  
	  //all ids from json body
	  .body("data.id", hasItems(7,8,9,10,11,12))
	  
	  //changing order
	  .body("data.id", hasItems(10,8,9,7,11,12))
	  
	  //partial IDs
	  .body("data.id", hasItems(10,7,12))
	  
	  //contains()
	  .body("data.id", contains(7,8,9,10,11,12))
	 // .body("data.id", contains(10,8,9,7,11,12))   //fail condition
	 // .body("data.id", contains(10,7,12))			//fail condition
	  
	  .log().body();
	  
  }
}
