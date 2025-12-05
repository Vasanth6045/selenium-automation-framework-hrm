package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HRMDashboardPage {
	public HRMDashboardPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'Offline Employees')]")
	private WebElement offlineEmployeeWidget;
	public WebElement getOfflineEmployeeWidget() {
		return offlineEmployeeWidget;
	}
	
	
}
