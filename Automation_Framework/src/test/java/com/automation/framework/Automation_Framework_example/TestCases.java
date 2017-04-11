package com.automation.framework.Automation_Framework_example;

import org.testng.annotations.Test;

public class TestCases extends  IntiliazeObjects {
	
//Testing AppDirect Page
	@Test(groups="titletest",priority=0)
	public void  AppDirectPageTest(){
		 AppDirectPage();
		 }
		
//Testing Login Page
	@Test(groups="titletest",priority=1)
	public void SignInClickPageTest(){
		SignInClick();
		}
		
//Testing SignUp Page
	@Test(groups="titletest",priority=2)
	public void  emailSignInPageTest(){
		 emailSignIn();
	}

//Testing EmailVerficationMessageDisplayed
	@Test(groups="titletest",priority=3)
	public void  emailSignInVerifyTest(){
		emailVerificationMessage();
	}
	
}


