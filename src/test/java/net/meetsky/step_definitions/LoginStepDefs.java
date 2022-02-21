package net.meetsky.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.pages.LoginPage;
import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.SkyDriver;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
      String url = ConfigurationReader.get("url");
        SkyDriver.get().get(url);
    }

    @When("the user enters the verified information")
    public void the_user_enters_the_verified_information() {
     String username = ConfigurationReader.get("username");
     String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {
        Thread.sleep(2000);
        String actualTitle = SkyDriver.get().getTitle();
        Assert.assertEquals("Files - Meetsky - QA", actualTitle);

    }
}
