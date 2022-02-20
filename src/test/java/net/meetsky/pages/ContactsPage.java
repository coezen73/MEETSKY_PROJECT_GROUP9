package net.meetsky.pages;

import net.meetsky.utilities.SkyDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage extends  BasePage{
    public ContactsPage(){
        PageFactory.initElements(SkyDriver.get(),this);
    }

    @FindBy( xpath = "//div[@id='contacts-list']/div[1]//div[@class='app-content-list-item-line-one']")
    public List<WebElement> contactList;

    @FindBy ( id = "new-contact-button" )
    public WebElement newContactButton;

    @FindBy ( id = "everyone" )
    public WebElement allContactButton;

    @FindBy ( id = "notgrouped" )
    public WebElement notGroupedButton;

    @FindBy ( xpath = "//span[@title='+ New group']" )
    public WebElement newGroupButton;

    @FindBy ( xpath = "//div[@class='app-content-details']")
    public WebElement contactAllContent;

    @FindBy ( id = "contact-fullname")
    public WebElement fullnamebox;

    @FindBy ( xpath = "//input[@inputmode='email']")
    public WebElement emailbox;

    @FindBy ( xpath = "//button[@aria-controls='menu-grwrp']")
    public WebElement threeDotIcon;

    @FindBy ( xpath = "//ul[@id='menu-grwrp']//span[@class='action-button__icon icon-delete']")
    public WebElement deletePerson;

    @FindBy ( xpath = "//h3")
    public WebElement emptyArea;
}
