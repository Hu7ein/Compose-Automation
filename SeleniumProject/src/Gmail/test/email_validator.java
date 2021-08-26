package Gmail.test;

import java.util.regex.Pattern;

public class email_validator {
	
    //taking input from the main class and validating the email 	
	protected boolean isValid(String email)
	{
	     String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
	                         "[a-zA-Z0-9_+&*-]+)*@" +
	                         "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	                         "A-Z]{2,7}$";
	   
	     //using system inbuilt Regex method to validate the email and sending output to main method                        
	     Pattern emailpattern = Pattern.compile(emailRegex);
	     if (email == null)
	         return false;
	    
	     return emailpattern.matcher(email).matches();
	} 


}
