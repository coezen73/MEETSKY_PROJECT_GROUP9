package net.meetsky.pages;

import net.meetsky.utilities.SkyDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

    public CalendarPage() {

        PageFactory.initElements(SkyDriver.get(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']//li[@data-id='calendar']//a")
    public WebElement CalendarButton;

    @FindBy (xpath = "//div[@class='new-event-today-view-section']/button[1]")
    public WebElement NewEventButton;

    @FindBy(id="f20e0c25-d928-42cc-98d1-13cc230663ea")
    public WebElement NewEventPopUpTable;

    @FindBy(xpath = "//input[@placeholder='Event title']")
    public WebElement EventTitleLine;

    @FindBy (xpath = "//div[@class='mx-datepicker'][1]//input")
    public WebElement fromDateLine;

    @FindBy (xpath = "//div[@class='mx-datepicker'][2]//input")
    public WebElement toDateLine;

    @FindBy(xpath = "//div[@class='event-popover__buttons']/button[@class='primary']")
    public WebElement SaveButton;

}
