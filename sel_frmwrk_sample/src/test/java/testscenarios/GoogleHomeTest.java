package testscenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageobjects.GoogleSearchHomePage;
import pageobjects.GoogleSearchResultPage;
import utilities.BaseClass;
import utilities.BrowserActions;
import utilities.DriverFactory;

//@Listeners(listeners.LogListener.class)	
public class GoogleHomeTest extends BaseClass{
	
	@Test
	public void test_google_home_title(){
		
		//test = exRepo.startTest("test_google_home_title");
		test.setDescription("Verifying title");
		logger.info("OPENING "+url+"...");
		driver.get(url);//"http://google.com"
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		
		BrowserActions actions = new BrowserActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		GoogleSearchHomePage gsh = new GoogleSearchHomePage(DriverFactory.getDriverInstance());
		logger.info("Searching something on google");
		
		//wait.until(ExpectedConditions.visibilityOf(gsh.getSearchInputBox())).sendKeys("selenium");
		//wait.until(ExpectedConditions.elementToBeClickable(gsh.getSearchButton())).click();
		
		actions.sendKeys(gsh.getSearchInputBox(), "Selenium");
		
		GoogleSearchResultPage gsr = gsh.clickOnSearchBtn();		
		Assert.assertEquals(driver.getTitle(), "Selenium - Google Search");
				
		/*exRepo.endTest(test);
		exRepo.flush();*/
			
		
	}
	
	@Test
	public void test_google_home_result_count(){
		
		test.setDescription("Verifying Count");
		
		test = exRepo.startTest("test_google_home_page");
		logger.info("OPENING GOOGLE.COM...");
		driver.get(url);//"http://google.com"
		driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		
		BrowserActions actions = new BrowserActions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		GoogleSearchHomePage gsh = new GoogleSearchHomePage(DriverFactory.getDriverInstance());
		logger.info("Searching something on google");
		
		//wait.until(ExpectedConditions.visibilityOf(gsh.getSearchInputBox())).sendKeys("selenium");
		//wait.until(ExpectedConditions.elementToBeClickable(gsh.getSearchButton())).click();
		
		actions.sendKeys(gsh.getSearchInputBox(), "selenium");
		
		GoogleSearchResultPage gsr = gsh.clickOnSearchBtn();		
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(gsr.getSearchStat())).getText(), "About 4,10,00,000 results (0.51 seconds)");
			
		exRepo.endTest(test);
		exRepo.flush();
		
	}

}
