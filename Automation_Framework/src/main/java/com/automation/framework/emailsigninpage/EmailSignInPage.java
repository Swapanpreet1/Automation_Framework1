package com.automation.framework.emailsigninpage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.automation.framework.fileutils.FileUtils;

public class EmailSignInPage{
	public static WebDriver driver;
	public String fileName="emailsignin.properties";
	FileInputStream fs;
	WebDriverWait wait;
	final String randomEmail = randomEmail(); 
	String enterEmail1;
	String clickSignUp;
	FileUtils fu =new FileUtils();
	
	public  EmailSignInPage (WebDriver driver) {
		EmailSignInPage.driver=driver;
	}

	
 //Generating Random Email Every Time
     private static String randomEmail() {
	        return "random-" + UUID.randomUUID().toString() + "@yopmail.com";
	    }
   
 //getEmailSignInPageTitle    
     public String getEmailClickPageTitle() {
  		String  getEmailClickPageTitle= driver.getTitle();
  		System.out.println("SIGN UP PAGE " +  getEmailClickPageTitle);
  		return   getEmailClickPageTitle;
  	}

  
		
//ReadingPropertiesFile	 
	public void emailSignIn()  {
		Properties ps=new Properties();
	   try { fs =fu.readFile(fileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				Reporter.log("FileNotFoundException Caught"); }
	   try { ps.load(fs);
			}catch (IOException e) {
				e.printStackTrace();
				Reporter.log("IOException Caught");}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
	enterEmail1=ps.getProperty("enterEmail");
    clickSignUp=ps.getProperty("clickSignUp");
    enterEmail();
    clickSignUp();
    }
	
 //FindingTextBoxEnterEmailinsideTextBox
	public void enterEmail() {
	  wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(enterEmail1)));
	   try {
	driver.findElement(By.cssSelector(enterEmail1)).sendKeys(randomEmail);
	     }catch (NoSuchElementException e) {
	    	 Reporter.log("NoSuchElementException Caught");}
	 	}

//FinDingTextBoxClickingonSignUpButton
    public void  clickSignUp() {
    wait = new WebDriverWait(driver, 20);
  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(clickSignUp)));
    	try {
	driver.findElement(By.cssSelector(clickSignUp)).click();
	}catch (NoSuchElementException e) {
		Reporter.log("NoSuchElementException Caught");}
	}
}




