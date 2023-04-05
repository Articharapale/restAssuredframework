package Request_repositories;

import java.io.IOException;
import java.util.ArrayList;

import Common_method.getdata;

public class Post_Request_repositories {
public static String baseuri()
{
	String baseuri="https://reqres.in/api/users";
	return baseuri;
}
public static String resource()
{
	String resource="api/users";
	return resource;
}
public static String requestbody() throws IOException
{
	ArrayList<String> data=getdata.getdataexcel("Post_data","tc1");
	String name= data.get(2);
	String job= data.get(3);
	String requestbody="{\r\n"
			+ "    \"name\": \""+name+"\",\r\n"
			+ "    \"job\": \""+job+"\"\r\n"
			+ "}";
		
	return requestbody;
}
}
