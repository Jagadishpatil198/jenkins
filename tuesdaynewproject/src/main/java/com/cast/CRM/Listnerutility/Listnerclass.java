package com.cast.CRM.Listnerutility;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.CRM.generic.webdriverutility.Utilityobject;

import comcast.crm.basepagetest.Basepage;

public class Listnerclass  implements ITestListener,ISuiteListener {
public static	ExtentReports report;
public  ExtentTest  test;
public ExtentTest test1;
	@Override
	public void onStart(ISuite suite) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./advanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test suite results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.DARK);
		// config environment
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BRWOSER", "Chrome-121.11");
		
	}

	@Override
	public void onFinish(ISuite suite) {
	report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test=report.createTest(result.getMethod().getMethodName());
		 Utilityobject.settest(test);
		 test1 = Utilityobject.gettest();
		test1.log(Status.INFO," "+result.getMethod().getMethodName()+",start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test1.log(Status.INFO,"script success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		       String    Testname= result.getMethod().getMethodName();
		      Basepage base=new Basepage();
		      TakesScreenshot ts=(TakesScreenshot)Utilityobject.getdriver();
		  //   File srcfile = ts.getScreenshotAs(OutputType.FILE);
		    String filepath = ts.getScreenshotAs(OutputType.BASE64);
		     Capturetime capt=new Capturetime();

//		     File perm=new File("./screenshot/"+Testname+capt.time()+".png");
//		     try {
//				org.openqa.selenium.io.FileHandler.copy(srcfile, perm);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		     try {
		    	 
		     
		     test.addScreenCaptureFromBase64String(filepath, result.getMethod().getMethodName()+capt.time());
		     }catch (Exception e) {
				// TODO: handle exception
			}
		       
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
