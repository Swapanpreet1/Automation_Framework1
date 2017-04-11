package com.automation.framework.Automation_Framework_example;




import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.automation.framework.browsersetup.BrowserCollections;
import com.automation.framework.browsersetup.BrowserSetUp;

public class IntiliazeBrowser {
public static WebDriver driver1;
	
	@BeforeClass
    public void initliazebrowser() {
		Reporter.log("### BROWSER SETUP ###");
		String browsertype=BrowserCollections.WebBrowser();
		Reporter.log("*** Running choosen Browser ****");
		BrowserSetUp browsersetup=new BrowserSetUp();
	    driver1=(WebDriver)browsersetup.setBrowser(browsertype);
	}
	   
    @AfterClass
		public void destroyDriver(){
	    	//driver1.quit();
		}
    }

