package com.automation.framework.mainpage;



import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.automation.framework.fileutils.FileUtils;

public class AppDirectPage {
	public WebDriver driver;
	public String fileName="mainpage.properties";
	private String urlLink;
	WebDriverWait wait;
	private String LoginClick;
	 FileInputStream fs;
	FileUtils fu =new FileUtils();
	
	public  AppDirectPage(WebDriver driver) {
		this.driver = driver; 
    }

//getMainPageTitle 
	public String getMainPageTitle() {
		String getMainPageTitle = driver.getTitle();
		System.out.println(" MAIN PAGE " + getMainPageTitle);
		return  getMainPageTitle;
	}
	
//getMainPageUrl
	public String getMainPageUrl() {
		String getMainPageUrl = driver.getCurrentUrl();
		System.out.println(" MAIN PAGE " + getMainPageUrl);
		return  getMainPageUrl;
	}
	

//ReadingPropertiesFile	    
	public void mainPage()  { 
	Properties ps=new Properties();
    try { fs =fu.readFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Reporter.log("FileNotFoundException Caught"); }
	
    try { ps.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
			Reporter.log("IOException Caught");}

	 urlLink=ps.getProperty("urlLink");
	 LoginClick=ps.getProperty("LoginClick");
	 openMainPage();
	 LoginClick();
	 }
	
//OpenPageUrl
	public void openMainPage() {
		try{
		driver.get(urlLink);
	}catch (Exception e) {
		Reporter.log("Page not found Caught");}
	}

//FindingLoginButtonClickOnIt
	public void LoginClick() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LoginClick)));
		try {
		 driver.findElement(By.cssSelector(LoginClick)).click(); 
    }catch (NoSuchElementException e) {
    	Reporter.log("NoSuchElementException Caught");}
	}

}
