package Test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Project.Assertion;
import Project.BaseTest;
import Project.RestCalls;
import Utility.Testutil;
import Utility.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestAPI {
	
	 private String accessToken;
	 Response response;
	
	@BeforeTest
	public void setup() throws IOException
	{
	accessToken = BaseTest.login();
	}
	
	@Test
	public void getalluser()
	{
		String endpointURI = URL.getEndpoint("/user");
		
		response = new RestCalls().GetRequestwithheader(endpointURI, accessToken);
		String strresponse = Testutil.getResponsestring(response);
		JsonPath jsonres = Testutil.jsonparser(strresponse);
		String id = jsonres.getString("users[100]._id");
		
		Assertion.verifystatuscode(response, 200);
	
	
				
 
	}

}
