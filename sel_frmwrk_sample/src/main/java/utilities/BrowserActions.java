package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions {
	
	//WebDriver driver ;
	WebDriverWait wait;
	
	public BrowserActions(WebDriver driver){
		
		//driver = DriverFactory.getDriverInstance();
		wait = new WebDriverWait(driver, 10);
		
	}
	
	public void click(WebElement element){
		
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		
	}
	
	public void clear(WebElement element){
		
		wait.until(ExpectedConditions.visibilityOf(element)).clear();
		
	}
	
	public void sendKeys(WebElement element, String input){
		
		clear(element);
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(input);
		
	}

}
