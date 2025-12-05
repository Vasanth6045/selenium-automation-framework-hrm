package atlascoreHRM_smoke;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.HRMHomePage;
import objectrepository.HRMLoginPage;

public class TC_07 extends BaseClass {
		@Test(groups = "smoke")
		public void verifyEmployeeMenu() throws IOException {
			HRMLoginPage lp=new HRMLoginPage(wd);
			HRMHomePage hp=new HRMHomePage(wd);
			
			lp.loginHR("HRusername", "HRpassword");
			Assert.assertTrue(hp.getDashboardMENU().isDisplayed(),"home page not displayed");
			ObjectUtility.getTest().log(Status.INFO, "home page displayed");
			hp.getLeaveMENU().click();
			Assert.assertTrue(hp.getMyLeaveRequestSUBMENU().isDisplayed(),"leave sub menu's not displayed");
			ObjectUtility.getTest().log(Status.INFO, "leave sub menu's displayed");	
		}

}

