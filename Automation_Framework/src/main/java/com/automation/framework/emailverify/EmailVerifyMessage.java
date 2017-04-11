package com.automation.framework.emailverify;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.automation.framework.fileutils.FileUtils;


public class EmailVerifyMessage {
	public static WebDriver driver;
	public String fileName="emailsignin1.properties";
	FileInputStream fs;
	WebDriverWait wait;
	String emailVerifyMessgae1;
	FileUtils fu =new FileUtils();
	public  EmailVerifyMessage (WebDriver driver) {
		EmailVerifyMessage.driver=driver;
	}

//ReadingPropertiesFile
public void emailVerify()  {
		Properties ps=new Properties();
	    try { fs =fu.readFile(fileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				Reporter.log("FileNotFoundException Caught"); }
		
		try {ps.load(fs);
			}catch (IOException e) {
				e.printStackTrace();
				Reporter.log("IOException Caught");}
		
emailVerifyMessgae1=ps.getProperty("verifyMessage");
enterEmail1() ;
	}
	
//FindingEmailVerficationMessage	
public void enterEmail1() {
		try { WebElement ele=driver.findElement(By.className(emailVerifyMessgae1));
	   ele.getText();
	   System.out.println("message" +ele);}
		catch (NoSuchElementException e) {
		    	 Reporter.log("NoSuchElementException Caught");}
		 	}
}


