package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;

public class ExtentReportManager implements ITestListener 
{
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods
	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter(".\\src\\test\\java\\ExtentReport_TestNg\\myReport.html");//Specify location of the report
		sparkReporter.config().setDocumentTitle("Hackathon Project - Team Sharp Minds"); // Title of report
		sparkReporter.config().setReportName("Book One Way Outstation Cab and display the lowest charges"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK);		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);	
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester team","Sharp Minds");
		extent.setSystemInfo("Team Members","G.H.R.Shanmukha Sarma,Himal,Harshitha,Suyash");
		extent.setSystemInfo("os","Windows11");
		extent.setSystemInfo("Browser name","Chrome,Edge");
	}
 
	//Method to execute when test case execution is passed
	public void onTestSuccess(ITestResult result) 
	{
		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, "TEST CASE PASSED IS  :" + result.getName()); // update status p/f/s	
		
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
 
	//Method to execute when test case execution is failed
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
		
		TakesScreenshot s = (TakesScreenshot)BaseClass.driver;
		File src = s.getScreenshotAs(OutputType.FILE);
		File des = new File(".\\src\\test\\java\\ScreenShots\\Screenshot"+result.getName()+".png");
		try {
			FileUtils.copyFile(src, des);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
	}
 
	//Method to execute when test case execution is skipped
	public void onTestSkipped(ITestResult result) {
 
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
	}
 
	//Method to execute when test case execution is completed
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
