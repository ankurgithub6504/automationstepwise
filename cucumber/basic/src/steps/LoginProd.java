package steps;
import cucumber.api.java.en.And;

public class LoginProd {
	
	@And("^user validates the captcha image$")
	public void user_validates_the_captcha_image() throws Throwable {
	    System.out.println("user validates captcha image");
	}


}
