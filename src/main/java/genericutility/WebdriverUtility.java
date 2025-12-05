package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	//maximize
	public void maximize(WebDriver wd) {
		wd.manage().window().maximize();
	}
	//minimize
	public void minimize(WebDriver wd) {
		wd.manage().window().minimize();
	}
	//fullscreen
	public void fullScreen(WebDriver wd) {
		wd.manage().window().fullscreen();
	}
	//implicit wait
	public void implicitWait(WebDriver wd) {
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	//explicit wait
	public void explicitWait(WebDriver wd, WebElement element) {
		WebDriverWait wait=new WebDriverWait(wd,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	//wait until notificaton disappear
	public void waitForInvisiblityOfElement(WebDriver wd, WebElement element) {
		WebDriverWait wait=new WebDriverWait(wd, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	//switch to frame with index
	public void switchToFrame(WebDriver wd, int index) {
		wd.switchTo().frame(index);
	}
	//switch to frame with name or id
	public void switchToFrame(WebDriver wd, String name) {
		wd.switchTo().frame(name);
	}
	//switch to frame with web element name or id
	public void switchToFrame(WebDriver wd, WebElement nameORid) {
		wd.switchTo().frame(nameORid);
	}
	//switch back to main page
	public void switchToMainPage(WebDriver wd) {
		wd.switchTo().defaultContent();
	}
	//switch to parent frame
	public void switchToParentFrame(WebDriver wd) {
		wd.switchTo().parentFrame();
	}
	
	//actions class methods
	//mouse hover on web element
	public void mouseHover(WebDriver wd, WebElement element) {
		Actions act=new Actions(wd);
		act.moveToElement(element).perform();
	}
	//mouse hover with x and y coordinates
	public void mouseHover(WebDriver wd, int x, int y) {
		Actions act=new Actions(wd);
		act.moveByOffset(x,y).perform();
	}
	//right click
	public void rightClick(WebDriver wd) {
		Actions act=new Actions(wd);
		act.contextClick().perform();
	}
	//right click on element
	public void rightClick(WebDriver wd, WebElement element) {
		Actions act=new Actions(wd);
		act.contextClick(element).perform();
	}
	//double click
	public void doubleClick(WebDriver wd, WebElement element) {
		Actions act=new Actions(wd);
		act.moveToElement(element).perform();
	}
	//click and hold on element
	public void clickAndHold(WebDriver wd, WebElement element) {
		Actions act=new Actions(wd);
		act.clickAndHold(element).perform();
	}
	//click and hold
	public void clickAndHold(WebDriver wd) {
		Actions act=new Actions(wd);
		act.clickAndHold().perform();
	}
	//drag and drop
	public void dragAndDrop(WebDriver wd, WebElement source, WebElement target) {
		Actions act=new Actions(wd);
		act.dragAndDrop(source, target).perform();
	}
	//scroll to element
	public void scrollToElement(WebDriver wd,WebElement element) {
		Actions act=new Actions(wd);
		act.scrollToElement(element);
	}
	//scroll by amount
		public void scrollToElement(WebDriver wd,int x, int y) {
			Actions act=new Actions(wd);
			act.scrollByAmount(x,y);
		}
	//switch to window using url
	public void switchToWindoUsingUrl(WebDriver wd, String partialURL) {
		Set<String> allWinID = wd.getWindowHandles();
		for(String id:allWinID) {
			wd.switchTo().window(id);
			String url = wd.getCurrentUrl();
			if(url.contains(partialURL)) {
				break;
			}
		}	
	}
	//switch to window using title
	public void switchToWindoUsingTitle(WebDriver wd, String partialTitle) {
		Set<String> allWinID = wd.getWindowHandles();
		for(String id:allWinID) {
			wd.switchTo().window(id);
			String url = wd.getTitle();
			WebDriverWait wait=new WebDriverWait(wd, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.titleContains(partialTitle));
			if(url.contains(partialTitle)) {
				break;
			}
		}	
	}
	//switch to alert
	public void switchToAlertAndAccept(WebDriver wd) {
		wd.switchTo().alert().accept();
	}
	//switch to alert
	public void switchToAlertAndDismiss(WebDriver wd) {
		wd.switchTo().alert().dismiss();
	}
	//switch to alert and send data
	public void switchToAlertAndSendKeys(WebDriver wd, String key) {
		wd.switchTo().alert().sendKeys(key);
	}
	//switch to alert and get text
	public String switchToAlertAndGetText(WebDriver wd) {
		String text = wd.switchTo().alert().getText();
		return text;
	}
	//select class
	
	public void selectWithIndex(WebDriver wd, int index, WebElement element) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectWithValue(WebDriver wd, String value,WebElement element) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	
	public void selectWithText(WebDriver wd, String value, WebElement element ) {
		Select sel=new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public void deSelectWithVisibleText(WebDriver wd, String value, WebElement element ) {
		Select sel=new Select(element);
		sel.deselectByVisibleText(value);
	}
	
	public void deSelectWithValue(WebDriver wd, String value, WebElement element ) {
		Select sel=new Select(element);
		sel.deselectByValue(value);
	}
	
	public void deSelectWithIndex(WebDriver wd, int index, WebElement element) {
		Select sel=new Select(element);
		sel.deselectByIndex(index);
	}
	
	public void deselectAll(WebElement element) {
		Select sel=new Select(element);
		sel.deselectAll();
	}
	
	public List<WebElement> getAllOptions(WebElement element) {
		Select sel=new Select(element);
		return sel.getOptions();
	}
	
	public WebElement getFirstSelectedOption(WebElement element) {
		Select sel=new Select(element);
		return sel.getFirstSelectedOption();
	}
	
	public List<WebElement> getAllSelectedOptions(WebElement element) {
		Select sel=new Select(element);
		return sel.getAllSelectedOptions();
	}
	
	public boolean isMultiple(WebElement element) {
		Select sel=new Select(element);
		return sel.isMultiple();
	}
	
	//takescreen shot
	public void getScreenShot(WebDriver wd, String filename) throws IOException {
		String timestamp = LocalDateTime.now().toString().replace(":", "-");
		TakesScreenshot ts=(TakesScreenshot) wd;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+timestamp+filename+".png");
		FileHandler.copy(temp, dest);
	}
	//java script executor
	public void scrollBy(WebDriver wd, int horizondal, int vertical) {
		JavascriptExecutor js=(JavascriptExecutor) wd;
		js.executeScript("window.scrollBy("+horizondal+","+vertical+")");
	}
	
	public void scrollTo(WebDriver wd, int horizondal, int vertical) {
		JavascriptExecutor js=(JavascriptExecutor) wd;
		js.executeScript("window.scrollBy("+horizondal+","+vertical+")");
	}
	
	public void scrollTillBottom(WebDriver wd) {
		JavascriptExecutor js=(JavascriptExecutor) wd;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollIntoView(WebDriver wd, boolean value, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) wd;
		js.executeScript("arguments[0].scrollIntoView("+value+")",element);
	}
	
	public void JSclick(WebDriver wd, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) wd;
		js.executeScript("arguments[0].click();",element);
	}
	
}
