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











}
