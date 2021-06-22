package Project;

import java.io.IOException;

import org.testng.annotations.Test;

import Project.RestCalls;
import Utility.URL;
import Utility.payloadconvertor;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	static  Response response;
	
	@Test
	public static String login() throws IOException
	{
		//this line will go to resource and fetch teh payload and convert it to string
		String Loginpayload = payloadconvertor.generatepayloadstring("Login.json");
		
		//this line will fetch the URL alog with resource
		String endpointURI = URL.getEndpoint("/user/login");
		
		//i have to call the method which contains the post method from the restcall
		 response = RestCalls.PostRequest(endpointURI, Loginpayload);
		 
		 String strres = response.getBody().asString();
		 
		 JsonPath jsonres = new JsonPath(strres);
		 String accessToken = jsonres.getString("accessToken");
		 System.out.println(accessToken);
		return accessToken;
	}

}
