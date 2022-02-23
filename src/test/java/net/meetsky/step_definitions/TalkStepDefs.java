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

import net.meetsky.pages.MainPage;



import org.openqa.selenium.Alert;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import java.util.List;

public class TalkStepDefs {


    LoginPage loginPage = new LoginPage();
    TalkModulePage talkModulePage = new TalkModulePage();


    @Given("the user logged in")
    public void the_user_logged_in() {
        SkyDriver.get().get(ConfigurationReader.get("url"));
        loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));


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
        @When("Click {string} inbox")
        public void click_inbox(String string){
            new MainPage().talk.click();
            SkyUtils.waitForPageToLoad(5);
        }

        @When("Enter {string} into Search conversations or users inbox")
        public void enter_into_inbox (String name){
            TalkModulePage talkPage = new TalkModulePage();
            talkPage.searchInputBox.sendKeys(name + Keys.ENTER);

        }

        @When("Select user {string}")
        public void select_user(String contactName){
            WebElement contactInList = SkyDriver.get().findElement(By.xpath("//span[contains(.,'" + contactName + "')]"));
            contactInList.click();
        }

        @When("Click on Start call button")
        public void click_on_button() throws InterruptedException {
            TalkModulePage talkPage = new TalkModulePage();
            SkyUtils.waitForClickablility(talkPage.startCallButton, 5);
//        JavascriptExecutor jse = (JavascriptExecutor) SkyDriver.get();
//        jse.executeScript("arguments[0].click();",talkPage.startCallButton);
            SkyDriver.get().navigate().refresh();
            try {
                talkPage.startCallButton.click();
            } catch (Exception e) {
                System.out.println("Did not click on Start call button");
            }

            try {
                Alert alert = SkyDriver.get().switchTo().alert();
                alert.accept();
            } catch (Exception e) {
                System.out.println("Mic&video message is not appeared");

            }

        }

        @Then("Verify video call page is shown.")
        public void verify_video_call_page_is_shown(){
            TalkModulePage talkPage = new TalkModulePage();
            SkyUtils.waitForVisibility(talkPage.waitingMessage, 5);
            Assert.assertTrue(talkPage.waitingMessage.isDisplayed());
            SkyUtils.waitFor(5);
        }
    @When("Click on {string} option on the right sidebar.")
    public void click_on_option_on_the_right_sidebar(String string) {
        TalkModulePage talkPage = new TalkModulePage();
//        talkPage.sideMenu.click();
        talkPage.participant.click();

    }

    @Then("Verify user {string} and participant {string} are shown on participant tab.")
    public void verify_user_and_participant_are_shown_on_participant_tab(String userName, String participantName) {
        TalkModulePage talkPage = new TalkModulePage();
        List<String> participants = SkyUtils.getElementsText(talkPage.participantList);
        Assert.assertTrue(participants.contains(userName));
        Assert.assertTrue(participants.contains(participantName));

    }
}

