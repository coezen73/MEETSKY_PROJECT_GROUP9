package net.meetsky.pages;


import net.meetsky.step_definitions.Hooks;
import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.SkyDriver;
import net.meetsky.utilities.SkyUtils;
import org.openqa.selenium.Cookie;

import net.meetsky.utilities.SkyDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;
import java.util.Set;

public class TalkModulePage {

    public TalkModulePage() {
        PageFactory.initElements(SkyDriver.get(), this);
    }


    @FindBy (xpath = "(//a[@aria-label='Talk'])[1]")
    public WebElement talkButton;

    @FindBy (xpath = "(//a[@class='app-navigation-toggle'])[1]")
    public WebElement talkButtonHamburger;

    @FindBy (xpath = "(//*[name()='path'])[2]")
    public WebElement plusButton;

    @FindBy (xpath = "//div[@id='app-navigation-vue']")
    public WebElement talkModule;

    @FindBy (xpath = "(//input[@placeholder='Conversation name'])[1]")
    public WebElement conversationName;

    @FindBy (xpath = "(//button[normalize-space()='Add participants'])[1]")
    public WebElement addParticipants;

    @FindBy (xpath = "(//button[normalize-space()='Create conversation'])[1]")
    public WebElement creatConversation;

    @FindBy (xpath = "(//span[normalize-space()='ca'])[1]")
    public WebElement converstaionCreated;


    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchInputBox;

    @FindBy (xpath = "//span[@class='acli__content__line-one__title']")
    public WebElement contactOnList;

    @FindBy (xpath = "//button[@class='top-bar__button top-bar__button primary']")
//    @FindBy (xpath = "//span[@class='icon icon-start-call']")
    public WebElement startCallButton;

    @FindBy (xpath = "//div[@id='call-container']//h2")
    public WebElement waitingMessage;

    @FindBy (xpath = "(//div[@class='top-bar']//button)[4]")
    public WebElement sideMenu;

    @FindBy (id = "participants")
    public WebElement participant;

    @FindBy (xpath = "//span[@class='participant-row__user-name']")
    public List<WebElement> participantList;

    @FindBy (xpath = "//button[contains(.,'Leave call')]")
    public WebElement leaveCallButton;

    @FindBy (xpath = "//div[contains(.,'Access to')]")
    public WebElement accessToWarningMessage;

    @FindBy (xpath = "//span[@class='toast-close']")
    public WebElement closeAccessToWarningMessage;


}


