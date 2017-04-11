package com.automation.framework.Automation_Framework_example;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.automation.framework.emailsigninpage.EmailSignInPage;
import com.automation.framework.emailverify.EmailVerifyMessage;
import com.automation.framework.mainpage.AppDirectPage;
import com.automation.framework.signinclickpage.SignInClickPage;

public class IntiliazeObjects extends IntiliazeBrowser {

//IntiliazePageObjects,AssertionsForPageTitle,ObjectNullOrNot
	public void AppDirectPage()  {
		 Reporter.log("###  LAUNCHING  APPDIRECT PAGE ###");
		 AppDirectPage mainpage = PageFactory.initElements(driver1, AppDirectPage.class);
	     mainpage.mainPage();
	     Reporter.log("ASSERTIONS FOR VERIFY APPDIRECTPAGE OBJECT NULL OR NOT");
		 Assert.assertNotNull(mainpage);
		 Reporter.log("ASSERTIONS FOR VERIFY APPDIRECTPAGE TITLE");
		 Assert.assertTrue(mainpage.getMainPageTitle().contains("AppDirect"));
		 Reporter.log("ASSERTIONS FOR VERIFY APPDIRECTPAGE URL");
		 Assert.assertEquals(mainpage.getMainPageUrl(), "https://www.appdirect.com/");
		}

//IntiliazePageObjects,AssertionsForPageTitle,ObjectNullOrNot
	public void SignInClick() {
		Reporter.log("###  LAUNCHING SIGNUP PAGE ###");
		SignInClickPage signin = PageFactory.initElements(driver1, SignInClickPage.class);
		signin.signInClickPage();
		Reporter.log("ASSERTIONS FOR VERIFY SIGNINPAGE OBJECT NULL OR NOT");
		Assert.assertNotNull(signin);
		Reporter.log("ASSERTIONS FOR VERIFY LOGINPAGE TITLE");
		Assert.assertTrue(signin.getSignInClickPageTitle().contains("Sign Up"));
		}
	
//IntiliazePageObjects,AssertionsForPageTitle,ObjectNullOrNot	
	public void emailSignIn()  {
		Reporter.log("###  LAUNCHING EMAILSIGNUP PAGE ###");
		EmailSignInPage email = PageFactory.initElements(driver1, EmailSignInPage.class);
		email.emailSignIn() ;
		Reporter.log("ASSERTIONS FOR VERIFY EMAILSIGNINPAGE OBJECT NULL OR NOT");
		Assert.assertNotNull(email);
		Reporter.log("ASSERTIONS FOR VERIFY EMAILSIGNIN TITLE");
		Assert.assertTrue(email.getEmailClickPageTitle().contains("Sign Up"));
		}

//IntiliazePageObjects,AssertionsForPageTitle,ObjectNullOrNot
	public void emailVerificationMessage() {
		Reporter.log("###  LAUNCHING EMAILVERIFYMESSAGE DISPLAYED ###");
		EmailVerifyMessage verify = PageFactory.initElements(driver1, EmailVerifyMessage.class);
		verify.emailVerify();
		Reporter.log("EmailVerification Message Displayed");
		}
	}
	

