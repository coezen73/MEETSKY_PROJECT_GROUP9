package net.meetsky.step_definitions;


import io.cucumber.java.en.When;

import net.meetsky.utilities.SkyDriver;
import net.meetsky.utilities.SkyUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.pages.CalendarPage;



public class CalendarStepDefs {

    CalendarPage calendarPage = new CalendarPage();


    @When("navigate to Calendar module")
    public void navigate_to_Calendar_module() {
        calendarPage.calendar.click();
        SkyUtils.waitFor(2);


    }

    @When("display all Day, Week, Month, List Options under the Hamburger menu")
    public void display_all_Day_Week_Month_List_Options_under_the_Hamburger_menu() {

        calendarPage.hamburgerButton.click();
        SkyUtils.waitFor(3);
        List<String> expected = SkyUtils.getElementsText(By.xpath("(//button//span[@class='action-button__text'])"));
        List <String> actual = new ArrayList<>(Arrays.asList("Day","Week","Month","List"));
        Assert.assertTrue(expected.containsAll(actual));


    }

    @When("clicking on Day, should display Daily calendar view")
    public void clicking_on_Day_should_display_Daily_calendar_view() {
        calendarPage.day.click();
        SkyUtils.waitFor(1);
        Assert.assertTrue(SkyDriver.get().getCurrentUrl().contains("Day"));
    }

    @When("clicking on Week, should display Weekly calendar view")
    public void clicking_on_Week_should_display_Weekly_calendar_view() {
        calendarPage.week.click();
        SkyUtils.waitFor(1);
        Assert.assertTrue(SkyDriver.get().getCurrentUrl().contains("Week"));
    }

    @When("clicking on Month, should display Monthly calendar view")
    public void clicking_on_Month_should_display_Monthly_calendar_view() {
        calendarPage.month.click();
        SkyUtils.waitFor(1);
        Assert.assertTrue(SkyDriver.get().getCurrentUrl().contains("Month"));
    }

    @When("clicking on List, should display List of calendar events")
    public void clicking_on_List_should_display_List_of_calendar_events() {
        calendarPage.list.click();
        SkyUtils.waitFor(1);
        Assert.assertTrue(SkyDriver.get().getCurrentUrl().contains("listMonth"));
    }

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
