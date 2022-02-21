package net.meetsky.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.pages.CalendarPage;
import net.meetsky.utilities.SkyUtils;

public class CalendarStepDefs {

    CalendarPage calendarPage = new CalendarPage();

    @Given("the user can click calendar button")
    public void the_user_can_click_calendar_button() {
        SkyUtils.waitFor(1);
       calendarPage.CalendarButton.click();
    }

    @When("the user can click {string} button")
    public void the_user_can_click_button(String NewEvent) {
        SkyUtils.waitFor(1);
        calendarPage.NewEventButton.click();
    }

    @When("the user should be able to see pop up page")
    public void the_user_should_be_able_to_see_pop_up_page() {
        SkyUtils.waitFor(1);
        calendarPage.NewEventPopUpTable.isDisplayed();
    }
    @Then("the user should be able to write {string} in the Event title line")
    public void the_user_should_be_able_to_write_in_the_Event_title_line(String title) {
        SkyUtils.waitFor(1);
        calendarPage.EventTitleLine.sendKeys(title);
    }
    @Then("the user should be able to write date from {string}")
    public void the_user_should_be_able_to_write_date_from(String fromDate) {
        SkyUtils.waitFor(1);
        calendarPage.fromDateLine.sendKeys(fromDate);
    }
    @Then("the user should be able to write date to {string}")
    public void the_user_should_be_able_to_write_date_to(String toDate) {
        SkyUtils.waitFor(1);
        calendarPage.toDateLine.sendKeys(toDate);
    }
    @When("the user can click the save button")
    public void the_user_can_click_the_save_button() {
        SkyUtils.waitFor(1);
        calendarPage.SaveButton.click();
    }

}
