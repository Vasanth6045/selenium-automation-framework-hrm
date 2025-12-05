package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMAttendancePage {
	
	public HRMAttendancePage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//div[@class='oh-main__titlebar oh-main__titlebar--left']")
	private WebElement attendancePageHEDDER;
	public WebElement getAttendancePageHEDDER() {
		return attendancePageHEDDER;
	}
	
	@FindBy(xpath = "//button[@class='oh-btn oh-btn--secondary ml-2']")
	private WebElement createBTN;
	public WebElement getCreateBTN() {
		return createBTN;
	}
	
	@FindBy(xpath = "//input[@id='id_attendance_date']")
	private WebElement attendanceDateTF;
	public WebElement getAttendanceDateTF() {
		return attendanceDateTF;
	}
	
	@FindBy(xpath = "//span[text()='---Choose Shift---']")
	private WebElement shiftDD;
	public WebElement getShiftDD() {
		return shiftDD;
	}
	
	@FindBy(xpath = "//li[text()='day shift']")
	private WebElement shiftTypeFullDay;
	public WebElement getShiftTypeFullDay() {
		return shiftTypeFullDay;
	}
	
	@FindBy(xpath = "//span[text()='---Choose Work Type---']")
	private WebElement workTypeDD;
	public WebElement getWorkTypeDD() {
		return workTypeDD;
	}
	
	@FindBy (xpath = "//li[text()='WFO']")
	private WebElement workTypeWFO;
	public WebElement getWorkTypeWFO() {
		return workTypeWFO;
	}
	
	@FindBy(xpath = "//input[@name='attendance_clock_in_date']")
	private WebElement checkInDateTF;
	public WebElement getCheckInDateTF() {
		return checkInDateTF;
	}
	
	@FindBy(xpath = "//input[@name='attendance_clock_out_date']")
	private WebElement checkOutDateTF;
	public WebElement getCheckOutDateTF() {
		return checkOutDateTF;
	}
	
	@FindBy(xpath = "(//input[@name='attendance_clock_in'])[2]")
	private WebElement checkInTF;
	public WebElement getCheckInTF() {
		return checkInTF;
	}
	
	@FindBy(xpath = "(//input[@name='attendance_clock_out'])[2]")
	private WebElement checkOutTF;
	public WebElement getCheckOutTF() {
		return checkOutTF;
	}
	
	@FindBy(xpath = "//input[@id='id_attendance_worked_hour']")
	private WebElement workedHoursTF;
	public WebElement getWorkedHoursTF() {
		return workedHoursTF;
	}
	
	@FindBy(xpath = "//textarea[@id='id_request_description']")
	private WebElement requestDescriptionTF;
	public WebElement getRequestDescriptionTF() {
		return requestDescriptionTF;
	}
	
	@FindBy(xpath = "//span[@id='select2-id_employee_id-container']")
	private WebElement employeeTF;
	public WebElement getEmployeeTF() {
		return employeeTF;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Request')]")
	private WebElement requestBTN;
	public WebElement getRequestBTN() {
		return requestBTN;
	}
	
	@FindBy(xpath = "//span[@class='oh-timeoff-modal__user fw-bold m-0']")
	private WebElement validateAttendanceRequestHEDDER;
	public WebElement getValidateAttendanceRequestHEDDER() {
		return validateAttendanceRequestHEDDER;
	}
	
	@FindBy(xpath = "(//h2[@id='addEmployeeModalLabel'])[1]")
	private WebElement validateAttendanceRequestPageHEDDER;
	public WebElement getValidateAttendanceRequestPageHEDDER() {
		return validateAttendanceRequestPageHEDDER;
	}
	
	@FindBy(xpath = "(//button[@class='oh-modal__close'])[1]")
	private WebElement validateAttendanceRequestCloseICON;
	public WebElement getValidateAttendanceRequestCloseICON() {
		return validateAttendanceRequestCloseICON;
	}
	
	@FindBy(xpath = "//a[@class='oh-btn oh-btn--success w-100']")
	private WebElement approveBTN;
	public WebElement getApproveBTN() {
		return approveBTN;
	}
	
	
	

}
