package com.automation.framework.signinclickpage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.automation.framework.fileutils.FileUtils;

public class SignInClickPage {
	 
	public static WebDriver driver;
	String fileName="signinclick.properties";
    String signInclick;
	WebDriverWait wait;
	FileInputStream fileInput;
	FileUtils fu =new FileUtils();
	
	public  SignInClickPage(WebDriver driver) {
		SignInClickPage.driver=driver;
	}

//getMainPageTitle 
	public String getSignInClickPageTitle() {
		String  getSigninPageTitle = driver.getTitle();
		System.out.println(" LOGIN PAGE " + getSigninPageTitle);
		return  getSigninPageTitle;
	}
	
//ReadingPropertiesFile		
	public void signInClickPage()  {
		Properties ps=new Properties();

//Catching Exceptions
		
	    try { fileInput =fu.readFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Reporter.log("FileNotFoundException");}
		
			try { ps.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
				Reporter.log("IOException Caught");}
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);			
    signInclick=ps.getProperty("signInclick");
    signInClick(); 
    }

//FindingSignUpButtonClickOnIt
	public void signInClick() {
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(signInclick)));	
		try {
		driver.findElement(By.cssSelector(signInclick)).click(); 
     }catch (NoSuchElementException e) {
    	 Reporter.log("NoSuchElementException Caught");}
 	}

}
