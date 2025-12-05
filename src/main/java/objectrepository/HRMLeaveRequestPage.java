package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMLeaveRequestPage {
	public HRMLeaveRequestPage(WebDriver wd) {
		PageFactory.initElements(wd,this);
	}
	@FindBy(xpath = "//h1[contains(text(),'Leave Requests')]")
	private WebElement leaveRequestsPageHedder;
	public WebElement getLeaveRequestsPageHedder() {
		return leaveRequestsPageHedder;
	}
	
	@FindBy(xpath = "//span[@class='oh-timeoff-modal__user fw-bold']")
	private WebElement leaveDetailsHedder;
	public WebElement getLeaveDetailsHedder() {
		return leaveDetailsHedder;
	}
	
	@FindBy(xpath = "(//button[@class='oh-modal__close--custom'])[2]")
	private WebElement leaveDetailsCloseICON;
	public WebElement getLeaveDetailsCloseICON() {
		return leaveDetailsCloseICON;
	}
	
	@FindBy(xpath = "//div[@class='oh-modal__button-container text-center mt-3']/div/a[@title='Approve']")
	private WebElement approveBTN;
	public WebElement getApproveBTN() {
		return approveBTN;
	}
	
	

}
