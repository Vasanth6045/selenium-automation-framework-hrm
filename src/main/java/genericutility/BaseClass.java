package genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectrepository.HRMHomePage;

public class BaseClass {
	public WebDriver wd;
	public static WebDriver Swd;
	public ExcelUtility eutil =new ExcelUtility();
	public WebdriverUtility wutil=new WebdriverUtility();
	public JavaUtility jutil=new JavaUtility();
	public FileUtility futil=new FileUtility();
	
/*************************************************************************************************************************/	
	
	@BeforeSuite(alwaysRun = true)
	public void reportConfig() {
		
	}
	
	@BeforeClass(alwaysRun = true)
		//launch browser
		public void openBrowse() throws IOException {
		String BROWSER=futil.getDataFromProperty("browser");
		//String BROWSER = System.getProperty("browser",futil.getDataFromProperty("browser"));
		if(BROWSER.contains("chrome")) {
			wd=new ChromeDriver();
		}else if(BROWSER.contains("edge")) {
			wd=new EdgeDriver();
		}else if(BROWSER.contains("safari")) {
			wd=new SafariDriver();
		}else if(BROWSER.contains("firefox")) {
			wd=new FirefoxDriver();
		}else {
			wd=new ChromeDriver();
		}
		Swd=wd;
		ObjectUtility.setDriver(wd);
		
		wutil.maximize(wd);
		wutil.implicitWait(wd);
		String URL = System.getProperty("url",futil.getDataFromProperty("url"));
		//String URL=futil.getDataFromProperty("url");
		wd.get(URL);//navigate to application using url
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException {
		
	}
		
	@AfterMethod(alwaysRun = true)
	public void logout() {
		HRMHomePage hp=new HRMHomePage(wd);
		hp.logout();
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		//close browser
		wd.quit();
	}
		
	@AfterSuite(alwaysRun = true)
	public void reporBackup() {
		//ereport.flush();
		//System.out.println("report backup done");
	}
}
