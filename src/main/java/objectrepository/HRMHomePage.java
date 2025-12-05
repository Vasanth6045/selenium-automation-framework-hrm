package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMHomePage {
	public HRMHomePage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//div[@id='mainNavProfile']")
	private WebElement profileMENU;
	public WebElement getProfileMENU() {
		return profileMENU;
	}

	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboardMENU;
	public WebElement getDashboardMENU() {
		return dashboardMENU;
	}
	
	@FindBy(xpath = "//a[@data-id='employeeGenericNav']")
	private WebElement employeeMENU;
	public WebElement getEmployeeMENU() {
		return employeeMENU;
	}
	
	@FindBy(xpath = "(//a[contains(text(),'Profile')])[1]")
	private WebElement profileSUBMENU;
	public WebElement getProfileSUBMENU() {
		return profileSUBMENU;
	}

	@FindBy(xpath = "//a[@data-id='leaveGenericNav']")
	private WebElement leaveMENU;
	public WebElement getLeaveMENU() {
		return leaveMENU;
	}
	
	@FindBy(xpath = "//a[contains(text(),'My Leave Requests')]")
	private WebElement myLeaveRequestSUBMENU;
	public WebElement getMyLeaveRequestSUBMENU() {
		return myLeaveRequestSUBMENU;
	}

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutLINK;
	public WebElement getLogoutLINK() {
		return logoutLINK;
	}
	
	@FindBy(xpath = "(//a[contains(text(),'Leave Requests')])[2]")
	private WebElement leaveRequestSUBMENU;
	public WebElement getLeaveRequestSUBMENU() {
		return leaveRequestSUBMENU;
	}
	
	@FindBy(xpath = "//div[@class='oh-alert oh-alert--animated oh-alert--success']")
	private WebElement notification;
	public WebElement getNotification() {
		return notification;
	}
	
	@FindBy (xpath = "//span[contains(text(),'Attendance')]")
	private WebElement attendanceMENU;
	public WebElement getAttendanceMENU() {
		return attendanceMENU;
	}
	
	@FindBy (xpath = "//a[contains(text(),'Attendance Requests')]")
	private WebElement attendanceRequestSUBMENU;
	public WebElement getAttendanceRequestSUBMENU() {
		return attendanceRequestSUBMENU;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Performance')]")
	private WebElement performanceMENU;
	public WebElement getPerformanceMENU() {
		return performanceMENU;
	}
	
	@FindBy(xpath = "//a[contains(text(),'Meetings')]")
	private WebElement meetingsSUBMENU;
	public WebElement getMeetingsSUBMENU() {
		return meetingsSUBMENU;
	}
	
	





	//business utility
	public void logout() {
		
		getProfileMENU().click();
		getLogoutLINK().click();
	}
	
}
