package com.automation.framework.browsersetup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import com.automation.framework.fileutils.FileUtils;


public class BrowserSetUp extends FileUtils {

//BrowserSetUp
	public WebDriver setBrowser(String driverValue) {
		 WebDriver driver;
		 FileInputStream fs = null;
		 String fileName="browserpath.properties";
		 Properties ps=new Properties();
//Catching Exceptions
         try { fs =readFile(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			 Reporter.log("FileNotFoundException Caught"); }
		 try { ps.load(fs);
		 } catch (IOException e) {
			e.printStackTrace();
			Reporter.log("IOException Caught"); }
		 String chromDriverPath=ps.getProperty("chromeDriverPath");
		 String firefoxDriverPath=ps.getProperty("fireFoxDriverPath");
		 String safariDriverPath=ps.getProperty("chromeDriverPath");
		 if (BrowserType.Safari.toString().equalsIgnoreCase(driverValue)){
				Reporter.log("#### SAFARI BROWSER STARTED ####"); 
				System.setProperty("webdriver.gecko.driver",safariDriverPath);
				DesiredCapabilities capabilities=DesiredCapabilities.safari();
				capabilities.setCapability("marionette", true);
				driver = new SafariDriver(capabilities);
	    } else if(BrowserType.Firefox.toString().equalsIgnoreCase(driverValue)){
				Reporter.log("#### FIREFOX BROWSER STARTED ####"); 
			    System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
			    DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			   capabilities.setCapability("marionette", true);
			    driver = new FirefoxDriver(capabilities);
	    } else { Reporter.log("#### CHROMEDRIVER STARTED ####"); 
			   System.setProperty("webdriver.chrome.driver",chromDriverPath);
			   driver = new ChromeDriver();
			
		}
		return driver;
		
	}

}
