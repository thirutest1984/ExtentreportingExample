package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestListener implements ITestListener {
	
	public static ExtentReports reports;
	public static ExtentTest test;

	public void onFinish(ITestContext context) {
		System.out.println("on finish");
		reports.endTest(test);
		reports.flush();		
	}

	public void onStart(ITestContext context) {
		System.out.println("on start");
		reports = new ExtentReports(new SimpleDateFormat("yyyy-mm-dd hh-mm-ss-ms").format(new Date())+"reports.html");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		System.out.println("on test sucess within percentage");
	}

	public void onTestFailure(ITestResult Result) {
		System.out.println("on test failure");
		test.log(LogStatus.FAIL, Result.getMethod().getMethodName()+ " test is failed");
		
		// taking screeshot at failure
	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("on test skipped");
		test.log(LogStatus.SKIP, Result.getMethod().getMethodName()+ " test is skipped");	}

	public void onTestStart(ITestResult Result) {
		System.out.println("on test start");
		test = reports.startTest(Result.getMethod().getMethodName());
		test.log(LogStatus.INFO, Result.getMethod().getMethodName()+" test is started");
	}

	public void onTestSuccess(ITestResult Result) {
		System.out.println("on test success");
		test.log(LogStatus.PASS, Result.getMethod().getMethodName()+" test is passed");

	}

}
