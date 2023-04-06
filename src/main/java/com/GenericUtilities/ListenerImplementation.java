package com.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation  implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//execution start from here
		String methodname = result.getMethod().getMethodName();
		test =report.createTest(methodname);
		Reporter.log(methodname+"----------->Testscript execution started");
	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+"----->Passed");
		Reporter.log(methodname+"------> Testscript execution successfull");
	}

	public void onTestFailure(ITestResult result) {

//				String FScript = result.getMethod().getMethodName();
//				String FS = FScript+ new JavaUtility().getSystemDate();
//				EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
//				File src = edriver.getScreenshotAs(OutputType.FILE);
//				File dst = new File("./Screenshot/"+FS+".png");
//				File path = dst.getAbsoluteFile();
//				
//				try {
//					FileUtils.copyFile(src, dst);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}


		String FScript = result.getMethod().getMethodName();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+FScript+".png");
		File path = dst.getAbsoluteFile();
		
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			String screenshot = WebDriverUtility.getScreenshot(BaseClass.sdriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshot);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("Testscript execution failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+"------->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("TestScript execution Skipped");
	}

	public void onStart(ITestContext context) {

		//create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("Online Shopping App");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("OSA");

		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "Chrome");
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("BAse_URL","https://localhost:8888");
		report.setSystemInfo("Reporter Name", "KArthikeyan");

	}

	public void onFinish(ITestContext context) {
		//Consolidate the report
		report.flush();

	}
}
