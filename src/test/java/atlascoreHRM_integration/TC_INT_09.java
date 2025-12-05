package atlascoreHRM_integration;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ObjectUtility;
import objectrepository.HRMHomePage;
import objectrepository.HRMLoginPage;
import objectrepository.HRMMeeingsPage;

public class TC_INT_09 extends BaseClass{
	@Test
	public void scheduleMeeting() throws IOException {
		HRMLoginPage lp=new HRMLoginPage(wd);
		HRMHomePage hp=new HRMHomePage(wd);
		HRMMeeingsPage mp=new HRMMeeingsPage(wd);
		
		
        // Login as HR
		lp.loginHR("HRusername", "HRpassword");
        // Wait for notification to disappear
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(),"logged in as HR home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "logged in as HR home page displayed");
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
        // Click Performance menu
		hp.getPerformanceMENU().click();
        // Click Meetings sub menu
		hp.getMeetingsSUBMENU().click();
        // Assert meetings page is displayed
		Assert.assertTrue(mp.getMeetingsPageHEDDER().isDisplayed(),"Meetings page not displayed");
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
		ObjectUtility.getTest().log(Status.INFO, "Meetings created successfully");
        // Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
        // Logout HR
		hp.logout();
        // Login as Employee
		lp.loginEmployee("EMPemail","EMPpassword");
		Assert.assertTrue(hp.getDashboardMENU().isDisplayed(),"home page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "logged in as Employee home page displayed");
        // Wait for notification to disappear
		wutil.waitForInvisiblityOfElement(wd, hp.getNotification());
        // Click Performance menu
		hp.getPerformanceMENU().click();
        // Click Meetings sub menu
		hp.getMeetingsSUBMENU().click();
        // Assert meetings page visible for employee
		Assert.assertTrue(mp.getMeetingsPageHEDDER().isDisplayed(),"Meetings page not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Meetings page displayed");
        // Convert HR date format for employee view
		//String dt = jutil.convertDateForHR(date);
        // Open meeting based on date and time
		wd.findElement(By.xpath("//span[contains(text(),'"+meetingTitle+"')]/ancestor::div[contains(@class,'oh-sticky-table__tr') and contains(@class,'oh-permission-table__tr') and contains(@class,'oh-permission-table--collapsed')]/descendant::div[@data-cell-index='3']")).click();
        // Assert meeting details popup displayed
		Assert.assertTrue(mp.getMeetingDetailsHEDDER().isDisplayed(),"Meetings details modale not displayed");
		ObjectUtility.getTest().log(Status.INFO, "Meetings details modale displayed");
        // Assert meeting details visible
		Assert.assertTrue(mp.getMeetingTitle().getText().contains(meetingTitle),"Meetings details not visible for employee");
		ObjectUtility.getTest().log(Status.INFO, "Meetings details visible for employee");
        // Close meeting details popup
		mp.getMeetingDetailsCloseICON().click();

		
	}
}
