package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMMyLeaveRequestPage {
	public HRMMyLeaveRequestPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//div[@class='oh-main__titlebar oh-main__titlebar--left']")
	private WebElement myLeaveRequestHedder;
	public WebElement getMyLeaveRequestHedder() {
		return myLeaveRequestHedder;
	}
	
	@FindBy(xpath = "//button[@id='requestCreateButton']")
	private WebElement createBTN;
	public WebElement getCreateBTN() {
		return createBTN;
	}
	
	@FindBy(xpath = "//span[@id='select2-id_leave_type_id-container']")
	private WebElement chooseLeaveTypeDD;
	public WebElement getChooseLeaveTypeDD() {
		return chooseLeaveTypeDD;
	}
	
	@FindBy(xpath = "//li[text()='sick']")
	private WebElement leaveTypeSick;
	public WebElement getLeaveTypeSick() {
		return leaveTypeSick;
	}
	
	@FindBy(xpath = "//span[@id='select2-id_start_date_breakdown-container']")
	private WebElement startDateBreakdownDD;
	public WebElement getStartDateBreakdownDD() {
		return startDateBreakdownDD;
	}
	
	@FindBy(xpath = "//li[text()='Full Day']")
	private WebElement startDateBreakdownFullday;
	public WebElement getStartDateBreakdownFullday() {
		return startDateBreakdownFullday;
	}
	
	@FindBy(xpath = "(//input[@id='id_start_date'])[2]")
	private WebElement startDateTF;
	public WebElement getStartDateTF() {
		return startDateTF;
	}
	
	@FindBy(xpath = "(//input[@id='id_end_date'])[2]")
	private WebElement endDateTF;
	public WebElement getEndDateTF() {
		return endDateTF;
	}
	
	@FindBy(xpath = "//span[@aria-labelledby='select2-id_end_date_breakdown-container']")
	private WebElement endDateBreakDown;
	public WebElement getEndDateBreakDown() {
		return endDateBreakDown;
	}
	
	@FindBy(xpath = "//li[text()='Full Day']")
	private WebElement endDateBreakDownFullday;
	public WebElement getEndDateBreakDownFullday() {
		return endDateBreakDownFullday;
	}
	
	@FindBy(xpath = "//textarea[@id='id_description']")
	private WebElement descriptionTF;
	public WebElement getDescriptionTF() {
		return descriptionTF;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveBTN;
	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	
	
	
	
	

}
