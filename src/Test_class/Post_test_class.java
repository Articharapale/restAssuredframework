package Test_class;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_method.Common_method_utilities;
import Common_method.Post_Common_method;
import Request_repositories.Post_Request_repositories;
import io.restassured.path.json.JsonPath;

public class Post_test_class {
	@Test
	public static void Orchestrator() throws IOException 
	{   
		String responsebody="";
		int responsestatuscode=0;
		String baseuri=Post_Request_repositories.baseuri();
		String resource=Post_Request_repositories.resource();
		String requestbody=Post_Request_repositories.requestbody();
		
		for(int i=0; i<5; i++)
		{
		responsestatuscode=Post_Common_method.responsestatuscode(baseuri,resource,requestbody);
		if(responsestatuscode==201)
		{
			responsebody=Post_Common_method.responsebody(baseuri,resource,requestbody);
			resonsebodyValidator(responsebody);
			break;
		}
		else
		{
			System.out.println("status code is not correct" +i);		
		}
        		
		}
		Common_method_utilities.evidencefilecreator("Post_test_class",requestbody,responsebody);
		Assert.assertEquals(responsestatuscode,201);
	}
	public static void resonsebodyValidator(String responsebody)
	{
		//create json path object
		JsonPath obj=new JsonPath(responsebody);
	//extract responsesbody parameter
	 String res_name=obj.getString("name");
	 //System.out.println(res_name);
	 String res_job=obj.getString("job");
	 //System.out.println(res_job);
	 String res_id=obj.getString("id");
	 //System.out.println(res_id);
	 String res_createdAt=obj.getString("createdAt");
	 //System.out.println(res_createdAt);
	 
	 //validate responsesbody
	 Assert.assertEquals(res_name,"morpheus");
	 Assert.assertEquals(res_job,"leader");
	 Assert.assertNotNull("id");
	 
	 String Date=new String(res_createdAt);
	 //System.out.println(Date.substring(0,10));
	 
	 String result=new String(Date);
	  //System.out.println(result.substring(0,10));
	 
	 Assert.assertEquals(Date, result);
	}

}
