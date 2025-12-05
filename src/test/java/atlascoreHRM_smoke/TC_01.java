package atlascoreHRM_smoke;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.HRMDashboardPage;
import objectrepository.HRMHomePage;
import objectrepository.HRMLoginPage;
@Listeners(genericutility.ListnerUtility.class)
public class TC_01 extends BaseClass{
	@Test(groups = "smoke")
	public void loginToApp() throws IOException {
		HRMLoginPage lp=new HRMLoginPage(wd);
		HRMHomePage hp=new HRMHomePage(wd);
		HRMDashboardPage dp=new HRMDashboardPage(wd);
		
		lp.loginHR("HRusername", "HRpassword");
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(),"home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "home page displayed");
		hp.getDashboardMENU().click();
		Assert.assertTrue(dp.getOfflineEmployeeWidget().isDisplayed(),"dashboard not displayed");
		ObjectUtility.getTest().log(Status.INFO, "dashboard displayed");
		
		
	}

}
