package atlascoreHRM_integration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.HRMHomePage;
import objectrepository.HRMLeaveRequestPage;
import objectrepository.HRMLoginPage;
import objectrepository.HRMMyLeaveRequestPage;

public class TC_INT_01 extends BaseClass{
	@Test
	public void leaveRequest() throws IOException {
		// Create object for Login Page
		HRMLoginPage lp=new HRMLoginPage(wd);
		// Create object for Home Page
		HRMHomePage hp=new HRMHomePage(wd);
		// Create object for My Leave Request Page
		HRMMyLeaveRequestPage mlrp=new HRMMyLeaveRequestPage(wd);
		// Create object for HR Leave Request Page
		HRMLeaveRequestPage lrp=new HRMLeaveRequestPage(wd);
			
		// Login as employee using credentials from property file
		lp.loginEmployee("EMPemail","EMPpassword");
		// Wait until notification disappears
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		// Verify home page is displayed
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(),"logged in as Employee home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "logged in as Employee home page displayed");
		// Click Leave menu from left panel
		hp.getLeaveMENU().click();
		// Click My Leave Request submenu
		hp.getMyLeaveRequestSUBMENU().click();
		// Validate My Leave Request page header
		Assert.assertTrue(mlrp.getMyLeaveRequestHedder().getText().contains("My Leave Requests"),"my leave request page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "my leave request page displayed");
		// Click Create button to apply a new leave
		mlrp.getCreateBTN().click();
		// Click dropdown to choose leave type
		mlrp.getChooseLeaveTypeDD().click();
		// Select Sick leave option
		mlrp.getLeaveTypeSick().click();
			
		// Click start date breakdown dropdown
		mlrp.getStartDateBreakdownDD().click();
		// Select full day option for start date
		mlrp.getStartDateBreakdownFullday().click();
		// Generate unique future date
		String startdate = jutil.getUniqueFutureDate(1, 150);
		// Enter start date
		mlrp.getStartDateTF().sendKeys(startdate);
		// Enter end date (same as start date)
		mlrp.getEndDateTF().sendKeys(startdate);
		// Open end date breakdown dropdown
		mlrp.getEndDateBreakDown().click();
		// Select full day option for end date
		mlrp.getEndDateBreakDownFullday().click();
		// Enter leave description
		mlrp.getDescriptionTF().sendKeys("sick");
		// Save the leave request
		mlrp.getSaveBTN().click();
		
		// Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		ObjectUtility.getTest().log(Status.INFO, "Leave applyed succesfully");
		// Logout from Employee account
		hp.logout();
		// Login as HR
		lp.loginHR("HRusername", "HRpassword");
		// Wait until notification disappears
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		// Verify HR home page is displayed
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(),"logged in as HR home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "logged in as HR home page displayed");
		// Click Leave menu in HR panel
		hp.getLeaveMENU().click();
		// Click Leave Request submenu
		hp.getLeaveRequestSUBMENU().click();
		// Validate Leave Requests page header
		Assert.assertTrue(lrp.getLeaveRequestsPageHedder().isDisplayed(),"leave requests page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "leave requests page displayed");
		// Convert employee date format to HR format
		String dt = jutil.convertDateForHR(startdate);
		// Locate the applied leave request using dynamic xpath
		WebElement StartdateHR = wd.findElement(By.xpath("(//div[text()='"+dt+"'])[1]"));
		// Click on the leave request row
		StartdateHR.click();
		// Verify details popup shows employee name
		Assert.assertTrue(lrp.getLeaveDetailsHedder().getText().contains("Hittler"),"leave requests not visible for HR");
		ObjectUtility.getTest().log(Status.INFO, "leave requests visible for HR");
		// Close leave details popup
		lrp.getLeaveDetailsCloseICON().click();
	}

}
