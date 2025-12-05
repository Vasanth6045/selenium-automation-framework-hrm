package objectrepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.FileUtility;

public class HRMLoginPage {
	public HRMLoginPage(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameTF;
	public WebElement getUsernameTF() {
		return usernameTF;
	}
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordTF;
	public WebElement getPasswordTF() {
		return passwordTF;
	}
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signinBTN;
	public WebElement getSigninBTN() {
		return signinBTN;
	}
	
	
	
	
	
	
	//business utilities
	
	public void loginHR(String UN, String PWD) throws IOException {
		FileUtility futil=new FileUtility();
		String username = futil.getDataFromProperty(UN);
		String password = futil.getDataFromProperty(PWD);
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signinBTN.click();
	}
	
	public void loginEmployee(String UN, String PWD) throws IOException {
		FileUtility futil=new FileUtility();
		String username = futil.getDataFromProperty(UN);
		String password = futil.getDataFromProperty(PWD);
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signinBTN.click();
	}
}
