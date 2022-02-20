package net.meetsky.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.pages.LoginPage;
import net.meetsky.pages.TalkModulePage;
import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.SkyDriver;
import net.meetsky.utilities.SkyUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class TalkStepDefs {

    LoginPage loginPage = new LoginPage();
    TalkModulePage talkModulePage = new TalkModulePage();


    @Given("the user logged in")
    public void the_user_logged_in() {
       SkyDriver.get().get(ConfigurationReader.get("url"));
       loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));


    }

    @When("navigate to Talk module")
    public void navigate_to_Talk_module() {

        talkModulePage.talkButton.click();
        SkyUtils.waitFor(5);

    }

    @When("display all conversation list under the Talk module")
    public void display_all_conversation_list_under_the_Talk_module() {

        Assert.assertTrue(talkModulePage.talkModule.isDisplayed());

    }

    @When("click on +sign button")
    public void click_on_sign_button() {

        talkModulePage.plusButton.click();

    }

    @When("enter conversation name and add click participants button")
    public void enter_conversation_name_and_add_click_participants_button() {

        talkModulePage.conversationName.sendKeys("user01");
        SkyUtils.waitFor(3);
        talkModulePage.addParticipants.click();
        SkyUtils.waitFor(1);
        talkModulePage.creatConversation.click();
        SkyUtils.waitFor(1);


    }

    @Then("user created new conversation")
    public void user_created_new_conversation() {
        List<String> a = SkyUtils.getElementsText(By.xpath("//ul[@class='app-navigation__list']"));

        for (String s : a) {
            Assert.assertTrue(s.contains("user01"));
        }


    }
}
