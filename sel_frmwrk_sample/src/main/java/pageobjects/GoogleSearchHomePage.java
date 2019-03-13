package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserActions;

public class GoogleSearchHomePage {
	
	protected WebDriver driver;
	//private WebDriverWait wait;
	private BrowserActions actions;
	
	@FindBy(name="q")
	private WebElement searchInputBox;
	
	@FindBy(name="btnK")
	private WebElement searchButton;
	
	public GoogleSearchHomePage(WebDriver driver){
		this.driver = driver;
		//wait = new WebDriverWait(this.driver, 10);
		actions = new BrowserActions(this.driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchInputBox() {
		return searchInputBox;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public GoogleSearchResultPage clickOnSearchBtn(){
		//wait.until(ExpectedConditions.elementToBeClickable(getSearchButton())).click();
		actions.click(getSearchButton());
		return new GoogleSearchResultPage(this.driver);
	}

}
