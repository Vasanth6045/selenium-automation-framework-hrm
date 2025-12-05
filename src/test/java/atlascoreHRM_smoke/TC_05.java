package atlascoreHRM_smoke;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.HRMHomePage;
import objectrepository.HRMLoginPage;

public class TC_05 extends BaseClass {
	@Test(groups = "smoke")
	public void verifyEmployeeMenu() throws IOException {
		HRMLoginPage lp=new HRMLoginPage(wd);
		HRMHomePage hp=new HRMHomePage(wd);
		
		lp.loginHR("HRusername", "HRpassword");
		WebElement employeeMenu = hp.getEmployeeMENU();
		Assert.assertTrue(employeeMenu.isDisplayed(),"home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "home page displayed");
		hp.getEmployeeMENU().click();
		Assert.assertTrue(hp.getProfileSUBMENU().isDisplayed(),"employee sub menu's not displayed");
		ObjectUtility.getTest().log(Status.INFO, "employee sub menu's displayed");
	}

}
