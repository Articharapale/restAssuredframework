package Test_class;

import java.io.IOException;

import org.testng.Assert;

import Common_method.Common_method_utilities;
import Common_method.Get_Common_method;
import Request_repositories.Get_Request_repositories;
import io.restassured.path.json.JsonPath;

public class Get_Test_class {
	public static void orchestrator() throws IOException
	{   
		String responsebody=""; 	
		int responsestatuscode=0; 
	    String baseuri=Get_Request_repositories.baseuri();
	    String resource=Get_Request_repositories.resource();
	    String requestbody=Get_Request_repositories.requestbody();
		for(int i = 0; i<5; i++)
		{
			responsestatuscode=Get_Common_method.responsestatuscode(baseuri,resource,requestbody);
			if(responsestatuscode==200)
			{
				responsebody=Get_Common_method.responsebody(baseuri,resource,requestbody);
				responsebodyValidator(responsebody);
				break;
			}
			else
			{
				System.out.println("status code is not correct" +i);
			}
		}
		Common_method_utilities.evidencefilecreator("Get_Test_class",requestbody,responsebody);
		Assert.assertEquals(responsestatuscode, 200);
	}
	public static void responsebodyValidator( String responsebody)
	{
		//create json path object
		JsonPath obj=new JsonPath(responsebody);
		
		//print array length
		int count=obj.getInt("data.size()");
		System.out.println(count);
		
		int id[]= {7,8,9,10,11,12};
		String email[]= {"michael.lawson@reqres.in","lindsay.ferguson@reqres.in","tobias.funke@reqres.in","byron.fields@reqres.in","george.edwards@reqres.in","rachel.howell@reqres.in"};
		String first_name[]= {"Michael","Lindsay","Tobias","Byron","George","Rachel"};
		String last_name[]= {"Lawson","Ferguson","Funke", "Fields","Edwards","Howell"};
	    String avatar[]= {"https://reqres.in/img/faces/7-image.jpg","https://reqres.in/img/faces/8-image.jpg","https://reqres.in/img/faces/9-image.jpg","https://reqres.in/img/faces/10-image.jpg","https://reqres.in/img/faces/11-image.jpg", "https://reqres.in/img/faces/12-image.jpg"};
	    
	    for(int i = 0; i<count; i++) {
	    	
	    	int exp_id=id[i];
	    	String exp_email=email[i];
	    	String exp_fname=first_name[i];
	    	String exp_lname=last_name[i];
	    	String exp_avatar=avatar[i];
	    	
	    //extract responsebody parameter
	    int res_id=obj.getInt("data["+i+"].id");
	    System.out.println(res_id);
	    String res_email=obj.getString("data["+i+"].email");
	    System.out.println(res_email);
	    String res_fname=obj.getString("data["+i+"].first_name");
	    System.out.println(res_fname);
	    String res_lname=obj.getString("data["+i+"].last_name");
	    System.out.println(res_lname);
	    String res_avatar=obj.getString("data["+i+"].avatar");
	    System.out.println(avatar);
	    
	    //validate responsebody
	    Assert.assertEquals(res_id,exp_id);
	    Assert.assertEquals(res_email,exp_email);
	    Assert.assertEquals(res_fname,exp_fname);
	    Assert.assertEquals(res_lname,exp_lname);
	    Assert.assertEquals(res_avatar,exp_avatar);

	    }
	}

}
