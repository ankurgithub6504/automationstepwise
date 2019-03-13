package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage {
	
	protected WebDriver driver;
	
	@FindBy(id="resultStats")
	private WebElement searchStat;
	
	public WebElement getSearchStat() {
		return searchStat;
	}

	public GoogleSearchResultPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
