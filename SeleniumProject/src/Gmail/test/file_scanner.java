package Gmail.test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class file_scanner {
	
    	//extracting data from file and sending it to the main method 	
	protected String email_list() throws IOException
	{  
	   //creating a file variable to read from the file	
	   File file = new File("C:/Users/asus/Desktop/email_list.txt");
	   Scanner sc = new Scanner(file);
	   String st = "";
	   
	   //checking that the file has data or its null  
	   while (sc.hasNextLine()) 
	   {
		   //if file has data then it will store data in the variable and will return it to the main method  
		   st += sc.nextLine();
	   }
	 	return st; 
	}

}
