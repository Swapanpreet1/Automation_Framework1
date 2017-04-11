package com.automation.framework.browsersetup;

import java.util.Scanner;
import org.testng.Reporter;

public class BrowserCollections {
private static String browserValue=null;
private static Scanner input;
	
	public static String WebBrowser() {  
        //Random random = new Random();
		//int choose = random.nextInt(4);
		 Reporter.log("****  Enter 1 for Chrome *** ",true);
		int choose;
        input = new Scanner(System.in);
        choose=input.nextInt();
        Reporter.log("1)  CHROME");
        Reporter.log("2)  FIREFOX");
        Reporter.log("3)  SAFARI");
  		switch(choose ) {
        case 1:Reporter.log("Chrome",true);
  		 browserValue="Chrome";       
  		 break;
  		 case 2: Reporter.log("Firefox",true);
  		 browserValue="Firefox";
  	     break;
  		 case 3:Reporter.log("SaFari");
  		 browserValue="Safari";
  		 break;
  		 default:Reporter.log("Chrome");
  		  browserValue="Chrome";
  		  }
  		 return browserValue;
  		 }
	}