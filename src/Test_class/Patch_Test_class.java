package Test_class;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Common_method.Common_method_utilities;
import Common_method.Patch_Common_method;
import Request_repositories.Patch_Request_repositories;
import io.restassured.path.json.JsonPath;

public class Patch_Test_class {
	@Test
	public static void orchestrator() throws IOException
	{    
		String responsebody ="";
		int responsestatuscode=0;
		String baseuri=Patch_Request_repositories.baseuri();
		String resource=Patch_Request_repositories.resource();
		String requestbody=Patch_Request_repositories.requestbody();
	
		for(int i = 0; i<5 ; i++) 
		{
			 responsestatuscode=Patch_Common_method.responsestatuscode(baseuri,resource,requestbody);
		     if(responsestatuscode==200)
		     {
		    	 responsebody=Patch_Common_method.responsebody(baseuri,resource,requestbody);
		    	 responsebodyValidator(responsebody);
		    	 break;
		     }
		     else
		     {
		    	 System.out.println("status code is not correct" +i);
		     }
		}
		   Common_method_utilities.evidencefilecreator("Patch_Test_class", requestbody, requestbody);
		   Assert.assertEquals(responsestatuscode,200);  
	}
	public static void responsebodyValidator(String responsebody)
	{
		//create json path obj
		JsonPath obj=new JsonPath(responsebody);
		
		//extract responsebody parameter
		String res_name=obj.getString("name");
		//System.out.println(res_name);
		String res_job=obj.getString("job");
		//System.out.println(res_job);
		String res_updatedAt=obj.getString("updatedAt");
		//System.out.println(res_updatedAt);
		
		//validate responsebody
		Assert.assertEquals(res_name,"morpheus");
		Assert.assertEquals(res_job,"zion resident");
		
		String Date=new String(res_updatedAt);
		//System.out.println(Date.substring(0,10));
		
		String result=new String(Date);
		//System.out.println(result.substring(0,10));
		
		Assert.assertEquals(Date,result);		
		
	}
}     
