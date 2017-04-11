package com.automation.framework.Automation_Framework_example;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersCheck implements ITestListener {

	public void onFinish(ITestContext arg0) {
		Reporter.log("");
	}

	public void onStart(ITestContext arg0) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	public void onTestFailure(ITestResult testFailedName) {
		Reporter.log("The name of the testcase failed is :"+testFailedName.getName());
	}

	public void onTestSkipped(ITestResult testSkippedName) {
		Reporter.log("The name of the testcase skipped is :"+testSkippedName.getName());
	}

	public void onTestStart(ITestResult testStarted) {
		Reporter.log( testStarted.getName() + "Test started");
		}

	public void onTestSuccess(ITestResult testCasePassed) {
		Reporter.log("The name of the testcase passed is :"+testCasePassed.getName());
	}

}
