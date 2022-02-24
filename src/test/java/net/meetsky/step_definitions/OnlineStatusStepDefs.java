package net.meetsky.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.meetsky.pages.OnlineStatusPage;

import org.junit.Assert;



public class OnlineStatusStepDefs {

    OnlineStatusPage onlineStatusPage = new OnlineStatusPage();

    //it is clicking Avatar then clicking Status Item
    @Then("click User Avatar module and click Status Item")
    public void click_User_Avatar_module_and_click_Status_Item() {

        onlineStatusPage.navigateToStatusElement();
    }

    //String option comes from feature as 4 different variable
    @Given("The user clicks an {string} on the online status section")
    public void the_user_clicks_an_on_the_online_status_section(String option) {

        onlineStatusPage.setOnlineStatusOption(option);
    }

    @Given("The user clicks an online on the online status section")
    public void the_user_clicks_an_online_on_the_online_status_section() {

    }
    //We are writing our status message and saving as a parameter in onlineStatusPage to later verify it
    @Then("The user writes any status message")
    public void the_user_writes_any_status_message() {
        onlineStatusPage.statusTextBox.clear();
        onlineStatusPage.expectedStatusMessage = "this is a status message";
        onlineStatusPage.statusTextBox.sendKeys(onlineStatusPage.expectedStatusMessage);

    }

    @Then("The user clicks set status message button")
    public void the_user_clicks_set_status_message_button() {
        onlineStatusPage.setStatusButton.click();

    }

    @Then("click User Avatar module")
    public void click_User_Avatar_module() {
        onlineStatusPage.navigateToAvatar();
    }

    @Then("status message must be chanced")
    public void status_message_must_be_chanced() {
        String actualStatusMessage =onlineStatusPage.statusMenuItem.getText();// we are taking the text of actual status message
        System.out.println("actualStatusMessage ----------------------= " + actualStatusMessage);
        System.out.println("onlineStatusPage.expectedStatusMessage ---------------------= " + onlineStatusPage.expectedStatusMessage);
        Assert.assertTrue(actualStatusMessage.contains(onlineStatusPage.expectedStatusMessage));//Comparing with expected massage that we hold in onlineStattusPage

        String actualIconClassAttribute = onlineStatusPage.onlineStatusIcon.getAttribute("class"); //we are taking actual of the Icon with class Attribute
        String expectedIconAttribute = "user-status-menu-item__toggle-icon icon-user-status-" + onlineStatusPage.option; //we are performing the expected IconClass
        Assert.assertEquals(expectedIconAttribute, actualIconClassAttribute); //Comparing with expected iconClass that we hold in onlineStatusPage

    }
    @Then("The user selects a {string}")
    public void the_user_selects_a(String preparedStatusOptionText) {
        onlineStatusPage.findPreparedStatusOptionElement(preparedStatusOptionText);
        onlineStatusPage.preparedStatusOption.click();
    }
    @Then("status message must be selected prepared status message")
    public void status_message_must_be_selected_prepared_status_message() {
    String actualStatusText=onlineStatusPage.statusMenuItem.getText();
        System.out.println("actualStatusText = " + actualStatusText);
        String expectedStatusTetx=onlineStatusPage.preparedStatusOptionText;
        System.out.println("expectedStatusTetx = " + expectedStatusTetx);
        Assert.assertTrue(actualStatusText.contains(expectedStatusTetx));
    }



}


