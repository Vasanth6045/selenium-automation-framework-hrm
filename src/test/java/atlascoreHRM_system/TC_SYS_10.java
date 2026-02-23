package atlascoreHRM_system;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.HRMHomePage;
import objectrepository.HRMLoginPage;
import objectrepository.HRMMeetingsPage;

public class TC_SYS_10 extends BaseClass {
	@Test
	public void createMeetingAndUpdateMOM() throws IOException, InterruptedException {
		HRMLoginPage lp = new HRMLoginPage(wd);
		HRMHomePage hp = new HRMHomePage(wd);
		HRMMeetingsPage mp = new HRMMeetingsPage(wd);

		// Login as HR
		lp.loginHR("HRusername", "HRpassword");
		// Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(), "HR home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "logged in as HR home page displayed");
		// Click Performance menu
		hp.getPerformanceMENU().click();
		// Click Meetings sub menu
		hp.getMeetingsSUBMENU().click();
		// Assert meetings page is displayed
		Assert.assertTrue(mp.getMeetingsPageHEDDER().isDisplayed(), "Meetings page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Meetings page displayed");
		// Click create button
		mp.getCreateBTN().click();
		// Enter meeting title
		String meetingTitle = eutil.getDataFromExcel("meeting", 1, 1)+jutil.getRandomNumber();
		mp.getTitleTF().sendKeys(meetingTitle);
		// Generate future date
		String date = jutil.getUniqueFutureDate(1, 300);
		// Enter date
		mp.getDateTF().sendKeys(date);
		// Press TAB to move to time field
		mp.getDateTF().sendKeys(Keys.TAB);
		// Enter meeting time
		mp.getDateTF().sendKeys("02:15PM");
		// Click employee field
		mp.getEmployeeTF().click();
		// Select employee
		mp.getEmployeeHittler().click();
		// Click save
		mp.getSaveBTN().click();
		ObjectUtility.getTest().log(Status.INFO, "Meeting created successfully");
		// Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		// Logout HR
		hp.logout();

		// Login as Employee
		lp.loginEmployee("EMPemail", "EMPpassword");
		// Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(), "home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "home page displayed");
		// Click Performance menu
		hp.getPerformanceMENU().click();
		// Click Meetings sub menu
		hp.getMeetingsSUBMENU().click();
		// Assert meetings page visible for employee
		Assert.assertTrue(mp.getMeetingsPageHEDDER().isDisplayed(), "Meetings page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Meetings page displayed");
		// Convert HR date format for employee view
		//String dt = jutil.convertDateForHR(date);
		// Open meeting based on date and time
		wd.findElement(By.xpath("//span[contains(text(),'"+meetingTitle+"')]/ancestor::div[contains(@class,'oh-sticky-table__tr') and contains(@class,'oh-permission-table__tr') and contains(@class,'oh-permission-table--collapsed')]/descendant::div[@data-cell-index='3']")).click();
		// Assert meeting details popup displayed
		Assert.assertTrue(mp.getMeetingDetailsHEDDER().isDisplayed(), "Meetings details modale not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Meetings details modale displayed");
		// Assert meeting details visible
		Assert.assertTrue(mp.getMeetingTitle().getText().contains(meetingTitle),"Meetings details not visible for employee");
		ObjectUtility.getTest().log(Status.INFO, "Meetings details visible for employee");
		// Close meeting details popup
		mp.getMeetingDetailsCloseICON().click();
		// logout as employee
		hp.logout();

		// Login as HR
		lp.loginHR("HRusername", "HRpassword");
		// Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(), "HR home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "logged in as HR home page displayed");
		// Click Performance menu
		hp.getPerformanceMENU().click();
		// Click Meetings sub menu
		hp.getMeetingsSUBMENU().click();
		// Assert meetings page is displayed
		Assert.assertTrue(mp.getMeetingsPageHEDDER().isDisplayed(), "Meetings page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Meetings page displayed");
		// click on add MOM + icon
		System.out.println(meetingTitle);
		wd.navigate().refresh();
		Thread.sleep(3000);
		WebElement addMOMIcon = wd.findElement(By.xpath("//span[.='"+meetingTitle+" "+"']/ancestor::div[@data-target='#objectDetailsModal']/descendant::a[@title='Add MoM']"));
		addMOMIcon.click();
		Assert.assertTrue(mp.getMinutesOfMeetingHEDDER().isDisplayed(), "Add MOM modale not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Add MOM modale displayed");
		String MOM = eutil.getDataFromExcel("meeting", 1, 0);
		mp.getAddMOMTF().sendKeys(MOM);
		mp.getMOMSaveBTN().click();
		ObjectUtility.getTest().log(Status.INFO, "Added MOM successfully");
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		// logout from hr account
		hp.logout();
		// login as employee
		lp.loginEmployee("EMPemail", "EMPpassword");
		// Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(), "Employee home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "logged in as employee home page displayed");
		// Click Performance menu
		hp.getPerformanceMENU().click();
		// Click Meetings sub menu
		hp.getMeetingsSUBMENU().click();
		// Assert meetings page visible for employee
		Assert.assertTrue(mp.getMeetingsPageHEDDER().isDisplayed(), "Meetings page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Meetings page displayed");
		// Open meeting based on date and time
		wd.findElement(By.xpath("//span[contains(text(),'"+meetingTitle+"')]/ancestor::div[contains(@class,'oh-sticky-table__tr') and contains(@class,'oh-permission-table__tr') and contains(@class,'oh-permission-table--collapsed')]/descendant::div[@data-cell-index='3']")).click();

		Assert.assertTrue(mp.getMeetingDetailsHEDDER().isDisplayed(), "Meetings details modale not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Meetings details modale displayed");
		// verify MOM Details are updated
		Assert.assertTrue(mp.getMOMDetailsTextArea().getText().contains(MOM),"Meetings MOM details not updated for employee");
		ObjectUtility.getTest().log(Status.INFO, "Meetings MOM details updated for employee");
		// Close meeting details popup
		mp.getMeetingDetailsCloseICON().click();

	}
}
