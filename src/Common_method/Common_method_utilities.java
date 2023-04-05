package Common_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Common_method_utilities {
public static void evidencefilecreator(String filename,String request,String response) throws IOException
{
	File newtextfile=new File("D:\\Rest_Assured_Evidence\\" + filename + ".txt");
	if(newtextfile.createNewFile())
	{
	FileWriter datawriter = new FileWriter(newtextfile);
	datawriter.write("Requestbody is: \n" +request+ "\n\n");
	datawriter.write("Responsebody is: \n" +response);
	datawriter.close();
	System.out.println("Request and Responsebody data saved in:" +newtextfile.getName());
	}
	else
	{
      System.out.println(newtextfile.getName() + " Allready exist plase take a backup this ");

	}
	
}
}
