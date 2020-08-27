package io.restassured.test;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

import io.restassured.base.TestBase;
import io.restassured.http.ContentType;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

public class GetTest extends TestBase {
	
  public String baseURI=null;
  public String endpointUrl=null;
  public String finalAPIURL=null;
  
public GetTest() throws IOException {
	super();
}

@BeforeMethod
public void setUp() {
	RestAssured.baseURI=prop.getProperty("baseurl");
	endpointUrl=prop.getProperty("serviceAPI");
	finalAPIURL=endpointUrl+"/page=2";
	}

  @Test (priority=1,description="Get the List of user")
  public void GetListUser() {
	  
	  String Resp=given().
			      when().
			      get(finalAPIURL).
			      then().assertThat().statusCode(200).and().
			      contentType(ContentType.JSON).and().
			      header("server","cloudflare").and().
			      body("page",equals(2)).and().
			      extract().
			      response().asString();
	  System.out.println("Response is--->"+Resp);
			      
 

}

}

