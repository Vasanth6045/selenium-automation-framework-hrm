package genericutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ObjectUtility {
	
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> wd=new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest acttest) {
		test.set(acttest);
	}
	
	
	public static WebDriver getDriver() {
		return wd.get();
	}
	public static void setDriver(WebDriver actdriver) {
		wd.set(actdriver);
	}

}
