package net.meetsky.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.pages.ContactsPage;
import net.meetsky.pages.LoginPage;
import net.meetsky.pages.MainPage;
import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.SkyDriver;
import net.meetsky.utilities.SkyUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class ContactsStepDefs {

    String fullname;
    String email;

    @Given("the user accesses the Log in page")
    public void the_user_accesses_the_Log_in_page() {
        SkyDriver.get().get(ConfigurationReader.get("url"));
    }
    @Given("the user login with valid credential {string} {string}")
    public void the_user_login_with_valid_credential(String username, String password) {
        String url = ConfigurationReader.get("url");
        SkyDriver.get().get(url);
        SkyUtils.waitForPageToLoad(5);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @When("Navigate to {string} module")
    public void navigate_to_module(String moduleName) {
        switch (moduleName){
            case "Contacts":
                new MainPage().contacts.click();
                break;
            case "Talk":
                new MainPage().talk.click();
                break;
        }
    }

    @When("Click {string} button")
    public void click_button(String newContact) {
        new ContactsPage().newContactButton.click();

    }

    @When("Enter a {string} into fullname inbox")
    public void enter_a_into_fullname_inbox(String fullname) {
        this.fullname=fullname;
        ContactsPage contactsPage=new ContactsPage();
        SkyUtils.waitForClickablility(contactsPage.fullnamebox,5);
        contactsPage.fullnamebox.clear();
        contactsPage.fullnamebox.sendKeys(fullname+ Keys.ENTER);

    }

    @When("Enter an {string} into Email inbox")
    public void enter_an_into_Email_inbox(String email) {
        this.email=email;
        ContactsPage contactsPage=new ContactsPage();
        contactsPage.emailbox.clear();
        SkyUtils.waitFor(3);
        contactsPage.emailbox.sendKeys(email);
        SkyUtils.waitForPageToLoad(2);
        System.out.println("email = " + contactsPage.emailbox.getText());
        SkyUtils.waitFor(5);
    }
    @When("Click any empty area")
    public void click_any_empty_area() {
        new ContactsPage().emptyArea.click();
    }


    @Then("Verify new contact is shown in contact list")
    public void verify_new_contact_is_shown_in_contact_list() {
        ContactsPage contactsPage = new ContactsPage();
        List<String> contacts = SkyUtils.getElementsText(contactsPage.contactList);
        SkyUtils.waitFor(2);
        System.out.println("fullname = " + fullname);
        Assert.assertTrue(contacts.contains(fullname));
    }

}
