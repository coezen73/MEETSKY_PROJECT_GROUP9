package net.meetsky.pages;

import net.meetsky.utilities.SkyDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarPage {
    public CalendarPage() { PageFactory.initElements(SkyDriver.get(), this);}

    @FindBy (xpath = "(//a[@aria-label='Calendar'])[1]")
    public WebElement calendar;

    @FindBy (xpath = "(//a[@class='app-navigation-toggle'])[1]")
    public WebElement first3button;

    @FindBy (xpath = "(//button[@aria-label='Actions'])[1]")
    public WebElement hamburgerButton;

    @FindBy (xpath = "(//button//span[@class='action-button__text'])")
    public WebElement allButtons;

    @FindBy (xpath = "(//span[normalize-space()='Day'])[1]")
    public WebElement day;

    @FindBy (xpath = "(//span[normalize-space()='Week'])[1]")
    public WebElement week;

    @FindBy (xpath = "(//span[normalize-space()='Month'])[1]")
    public WebElement month;

    @FindBy (xpath = "(//span[normalize-space()='List'])[1]")
    public WebElement list;



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
