package genericutility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerUtility implements ITestListener, ISuiteListener {
	JavaUtility jutil=new JavaUtility();
	// private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	public static ExtentTest test;
	public static ExtentReports report;
	public ExtentSparkReporter spark;
	//ITestListener methods
	@Override
	public void onTestStart(ITestResult result) {
		//actual execution starts from here
		test=report.createTest(result.getMethod().getMethodName());
		ObjectUtility.setTest(test);
		//test.log(Status.INFO, result.getMethod().getMethodName()+" -----> TEST STARTED <-----");
		ObjectUtility.getTest().log(Status.INFO, result.getMethod().getMethodName()+" -----> TEST STARTED <-----");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//test.log(Status.PASS, result.getMethod().getMethodName()+" -----> TEST COMPLETED <-----");
		ObjectUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" -----> TEST COMPLETED <-----");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.Swd;
		String base64filepath = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(base64filepath,testname+"_"+jutil.getSystemTime());
		//test.log(Status.FAIL, result.getMethod().getMethodName()+" FAILED");
		//test.log(Status.INFO, result.getMethod().getMethodName()+" -----> TEST FAILED <-----");
		ObjectUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" FAILED");
		ObjectUtility.getTest().log(Status.INFO, result.getMethod().getMethodName()+" -----> TEST FAILED <-----");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ObjectUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName() +" -----> TEST SKIPPED <-----");
	}

	@Override
	public void onStart(ITestContext context) {
		 
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	//ISuiteListener methods
	
	@Override
	public void onStart(ISuite suite) {
		spark=new ExtentSparkReporter("./ExtentReport/report_"+jutil.getSystemTime()+".html");
		spark.config().setDocumentTitle("title");
		spark.config().setReportName("");
		spark.config().setTheme(Theme.STANDARD);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Oerating System", "Windows_11");
		report.setSystemInfo("Browser", "chrome_latest");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}
}
