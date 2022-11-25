package hellocucumber;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.*;

import hello.User;
import hello.UserDatabase;

public class StepDefinitions {

	private Boolean canUserConnect;
	private String login;
	private User user;
	private UserDatabase userDatabase;
	
	@Given("user login is {string}")
	public void user_login_is(String login) {
		this.login = login;	
		this.userDatabase = new UserDatabase();
	}

	@And("user password is {string}")
	public void user_password_is(String password) {
		this.user = new User(this.login, password);
	}

	@When("I ask whether user can access to meteo data center")
	public void can_user_connect() {
		this.canUserConnect = this.userDatabase.isUserCorrect(this.user);
	}

	@Then("I should be told {string}")
	public void i_should_be_told(String expectedAnswer) {
		assertEquals(expectedAnswer, this.canUserConnect.toString());
	}

}