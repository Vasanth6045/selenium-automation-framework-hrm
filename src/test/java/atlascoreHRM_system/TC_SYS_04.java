package atlascoreHRM_system;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.HRMAttendancePage;
import objectrepository.HRMHomePage;
import objectrepository.HRMLoginPage;

public class TC_SYS_04 extends BaseClass {
	@Test
	public void ApplyAndApproveAttendanceRequest() throws IOException {
		HRMLoginPage lp = new HRMLoginPage(wd);
		HRMHomePage hp = new HRMHomePage(wd);
		// Create object for Attendance Page
		HRMAttendancePage ap = new HRMAttendancePage(wd);

		// Login as employee
		lp.loginEmployee("EMPemail", "EMPpassword");
		// Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		// Verify home page is displayed
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(), "home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "home page displayed");
		// Click Attendance menu
		hp.getAttendanceMENU().click();
		// Click Attendance Request sub menu
		hp.getAttendanceRequestSUBMENU().click();
		// Verify Attendance Request page header
		Assert.assertTrue(ap.getAttendancePageHEDDER().isDisplayed(), "Attendance page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Attendance page displayed");
		// Click Create button for new attendance request
		ap.getCreateBTN().click();
		// Validate Employee text field is displayed on new request page
		Assert.assertTrue(ap.getEmployeeTF().isDisplayed(), "New Attendance request page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "New Attendance request page displayed");
		// Generate random past date
		String attendanceDate = jutil.getUniquePastDate(1, 40);
		// Print the generated attendance date
		System.out.println(attendanceDate);
		// Enter attendance date
		ap.getAttendanceDateTF().sendKeys(attendanceDate);
		// Open Shift drop down
		ap.getShiftDD().click();
		// Select Full Day shift
		ap.getShiftTypeFullDay().click();
		// Wait until Work Type drop down becomes clickable
		wutil.explicitWait(wd, ap.getWorkTypeDD());
		// Open Work Type drop down
		ap.getWorkTypeDD().click();
		// Select WFO option
		ap.getWorkTypeWFO().click();
		// Clear check-in time and enter new time
		ap.getCheckInTF().clear();
		ap.getCheckInTF().sendKeys("10:00AM");
		// Clear check-out time and enter new time
		ap.getCheckOutTF().clear();
		ap.getCheckOutTF().sendKeys("06:30PM");
		// Enter description for attendance request
		ap.getRequestDescriptionTF().sendKeys("missed punch");
		// Scroll to Request button
		wutil.scrollIntoView(wd, false, ap.getRequestBTN());
		// Click Request button to submit attendance request
		ap.getRequestBTN().click();
		ObjectUtility.getTest().log(Status.INFO, "New Attendance request created successfully");
		// Wait for submission notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		// Logout from employee account
		hp.logout();
		// Login as HR
		lp.loginHR("HRusername", "HRpassword");
		// Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(), "HR home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "logged in as HR home page displayed");
		// Click Attendance menu
		hp.getAttendanceMENU().click();
		// Click Attendance Request submenu
		hp.getAttendanceRequestSUBMENU().click();
		// Verify Attendance Request page is displayed
		Assert.assertTrue(ap.getAttendancePageHEDDER().isDisplayed(), "Attendance page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Attendance page displayed");
		// Convert employee date format to HR format
		String dt = jutil.convertDateForHR(attendanceDate);
		// Print the converted HR date
		System.out.println(dt);
		// Locate and click the attendance request using dynamic XPath
		wd.findElement(By.xpath("(//div[text()='" + dt + "'])[1]")).click();
		// Validate request modal window header is displayed
		Assert.assertTrue(ap.getValidateAttendanceRequestPageHEDDER().isDisplayed(),"employee attendance request modale not displayed");
		ObjectUtility.getTest().log(Status.INFO, "employee attendance request modale displayed");
		// Validate correct employee name is shown in request
		Assert.assertTrue(ap.getValidateAttendanceRequestHEDDER().getText().contains("Hittler"),"employee attendance request not displayed");
		ObjectUtility.getTest().log(Status.INFO, "employee attendance request displayed");
		// click on approve button
		ap.getApproveBTN().click();
		// Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		// logout from HR account
		hp.logout();

		// login as employee
		lp.loginEmployee("EMPemail", "EMPpassword");
		// Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		// Verify home page is displayed
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(), "home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "home page displayed");
		// Click Attendance menu
		hp.getAttendanceMENU().click();
		// Click Attendance Request sub menu
		hp.getAttendanceRequestSUBMENU().click();
		// Verify Attendance Request page header
		Assert.assertTrue(ap.getAttendancePageHEDDER().isDisplayed(), "Attendance page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Attendance page displayed");
		List<WebElement> dates = wd.findElements(By.xpath("//div[@data-cell-index='2']"));
		boolean isPresent = false;
		for (WebElement d : dates) {
			if (d.getText().equals(dt)) {
				isPresent = true;
				break;
			}
		}
		Assert.assertFalse(isPresent, "Approved request is still visible in employee table!");
		ObjectUtility.getTest().log(Status.INFO, "Approved request successfully and not visible in employee table!");

	}
}
