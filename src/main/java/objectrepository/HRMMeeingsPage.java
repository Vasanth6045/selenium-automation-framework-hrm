package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMMeeingsPage {
	public HRMMeeingsPage(WebDriver wd) {
		PageFactory.initElements(wd,this);
	}
	
	@FindBy(xpath = "//h1[text()='Meetings']")
	private WebElement meetingsPageHEDDER;
	public WebElement getMeetingsPageHEDDER() {
		return meetingsPageHEDDER;
	}
	
	@FindBy(xpath = "//a[@class='oh-btn oh-btn--secondary']")
	private WebElement createBTN;
	public WebElement getCreateBTN() {
		return createBTN;
	}
	
	@FindBy(xpath = "//input[@id='id_title']")
	private WebElement TitleTF;
	public WebElement getTitleTF() {
		return TitleTF;
	}
	
	@FindBy(xpath = "(//input[@id='id_date'])[2]")
	private WebElement dateTF;
	public WebElement getDateTF() {
		return dateTF;
	}
	 
	@FindBy(xpath = "//div[@id='selectContainerid_employee_id']")
	private WebElement employeeTF;
	public WebElement getEmployeeTF() {
		return employeeTF;
	}
	
	@FindBy(xpath = "//li[text()='Hittler  ']")
	private WebElement employeeHittler;
	public WebElement getEmployeeHittler() {
		return employeeHittler;
	}
	
	@FindBy(xpath = "//div[@id='id_answer_employees_parent_div']")
	private WebElement answerableEmployeeTF;
	public WebElement getAnswerableEmployeeTF() {
		return answerableEmployeeTF;
	}
	
	@FindBy(xpath = "//li[text()=' Hittler  ']")
	private WebElement answerableEmployeeHittler;
	public WebElement getAnswerableEmployeeHittler() {
		return answerableEmployeeHittler;
	}
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement saveBTN;
	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Details')]")
	private WebElement meetingDetailsHEDDER;
	public WebElement getMeetingDetailsHEDDER() {
		return meetingDetailsHEDDER;
	}
	
	@FindBy(xpath = "(//span[@class='oh-timeoff-modal__stat-title '])[1]")
	private WebElement meetingDateAndTimeDetails;
	public WebElement getMeetingDateAndTimeDetails() {
		return meetingDateAndTimeDetails;
	}
	
	@FindBy(xpath = "//button[@class='oh-modal__close--custom']")
	private WebElement meetingDetailsCloseICON;
	public WebElement getMeetingDetailsCloseICON() {
		return meetingDetailsCloseICON;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Minutes of Meeting')]")
	private WebElement minutesOfMeetingHEDDER;
	public WebElement getMinutesOfMeetingHEDDER() {
		return minutesOfMeetingHEDDER;
	}
	
	@FindBy(xpath = "//div[@class='note-editable']")
	private WebElement addMOMTF;
	public WebElement getAddMOMTF() {
		return addMOMTF;
	}
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	private WebElement MOMSaveBTN;
	public WebElement getMOMSaveBTN() {
		return MOMSaveBTN;
	}
	
	@FindBy(xpath = "//div[@class='oh-timeoff-modal__stat-description']")
	private WebElement MOMDetailsTextArea;
	public WebElement getMOMDetailsTextArea() {
		return MOMDetailsTextArea;
	}
	
	@FindBy(xpath = "//span[@class='oh-timeoff-modal__user fw-bold']")
	private WebElement meetingTitle;
	public WebElement getMeetingTitle() {
		return meetingTitle;
	}
	
	
	
	
	
	
	
	
}
