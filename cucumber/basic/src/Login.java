import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	@Given("^user navigates to google page$")
	public void user_navigates_to_google_page() throws Throwable {
	   System.out.println("Navigating to Google page");
	}

	@When("^user validates the page title$")
	public void user_validates_the_page_title() throws Throwable {
	    System.out.println("Validating page title");
	}

	@Then("^user enters \"([^\"]*)\" username$")
	public void user_enters_valid_username(String username) throws Throwable {
	    System.out.println("Enters valid username "+username);
	}

	@And("^user enters \"([^\"]*)\" password$")
	public void user_enters_valid_password(String password) throws Throwable {
	    System.out.println("Enters valid password "+password);
	}

	@Then("^user \"([^\"]*)\" be successfully logged in$")
	public void user_should_be_successfully_logged_in(String validate) throws Throwable {
	    System.out.println(validate+" Logged in");
	}
	
	@And("^user selects the age category$")
	public void user_selects_the_age_category(DataTable table) throws Throwable {//List<String> list
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
	    System.out.println("selecting age "+data.get(0).get("Age"));//list.get(1)
	    System.out.println("selecting location "+data.get(0).get("Location"));
	}

}
