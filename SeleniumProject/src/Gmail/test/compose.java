package Gmail.test;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class compose 
{
	//Setting path of Chrome driver	
	static
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\Desktop\\Selenium\\chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		  //Initializing the Chrome driver	
		  ChromeDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  Thread.sleep(4000); 
		
		  //Entering the Email ID 
		  System.out.println("Enter Email: ");
		  Scanner scan1 = new Scanner(System.in);
		  String email;
		  email =  scan1.nextLine();	
		  WebElement username = driver.findElement(By.id("identifierId"));
		  username.sendKeys(email);
		  
		  //Clicking the Next button  
		  driver.findElement(By.xpath("//span[.='Next']")).click();
		  Thread.sleep(1000);
		  
		  //Entering the Password  
		  System.out.println("Enter Password : ");
		  Scanner pass = new Scanner(System.in);
		  String password = pass.nextLine();
		  WebElement passcode = driver.findElement(By.xpath("//input[@name='password']"));
		  passcode.sendKeys(password);
		
		  //Clicking Next Button  
		  driver.findElement(By.xpath("//span[.='Next']")).click();
		  Thread.sleep(3000);
		 
		  //Finding the Compose Button & Clicking it   
		  driver.findElement(By.xpath("//div[@jsname='dlrqf']")).click();
		  Thread.sleep(3000);
		 
		  //Initializing the object of file_scanner Class  
		  file_scanner fs = new file_scanner();
		
		  //Storing data of file in to the local variable  
		  String data = fs.email_list();
		  if(data==null) 
		  {
			System.out.println("File Empty");  
		  }
		  String[] reciever = data.split(",");
		
		  //Initializing the object email_validator class    
		  email_validator ev = new email_validator();
	  
	      //for loop for entering multiple recipients email addresses	  
		  for(String reciever_email : reciever){
			 
				Thread.sleep(1000);
			    //Checking that recipients email are Valid		  
				
				if(!ev.isValid(reciever_email)) 
					  {
				  		  //If invalid skipping that email and repeating the process and printing the invalid email addresses	
						  System.out.print("\n Email not valid   " + reciever_email);
						  continue;
				 	  }
			    //if email are valid adding them to recipients box in the compose window	
				reciever_email += " ";
				WebElement to_email= driver.findElement(By.xpath("//textarea[@name='to']"));
				to_email.sendKeys(reciever_email);  
		  }
	  
		  Thread.sleep(2000);
		
		  //Finding Subject Box and entering the subject
		  WebElement subject= driver.findElement(By.xpath("//input[@name='subjectbox']"));
		  subject.sendKeys("Incubyte");
		  Thread.sleep(2000);
		  
		  //finding the body part and entering the body of the email  
		  WebElement txt = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']"));
		  txt.sendKeys("Automation QA test for Incubyte \n");
		  Thread.sleep(10000);
		  
		  //finding the send email button and clicking it  
		  driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click();
		  Thread.sleep(2000);
		 
		  //After all tasks are completed closing the test window 
		  driver.close();
	}
}
  

