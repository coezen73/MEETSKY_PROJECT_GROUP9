package net.meetsky.pages;

import net.meetsky.utilities.SkyDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{
    public MainPage(){
        PageFactory.initElements(SkyDriver.get(),this);
    }

    @FindBy( id = "app-content-vue" )
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy ( xpath = "//ul[@id='appmenu']/li[1]")
    public WebElement files;

    @FindBy ( xpath = "//ul[@id='appmenu']/li[2]")
    public WebElement photos;

    @FindBy ( xpath = "//ul[@id='appmenu']/li[3]")
    public WebElement activity;

    @FindBy ( xpath = "//ul[@id='appmenu']/li[4]")
    public WebElement talk;

    @FindBy ( xpath = "//ul[@id='appmenu']/li[5]")
    public WebElement contacts;

    @FindBy ( xpath = "//ul[@id='appmenu']/li[6]")
    public WebElement calender;

    @FindBy ( xpath = "//ul[@id='appmenu']/li[7]")
    public WebElement notes;

    @FindBy ( xpath = "//ul[@id='appmenu']/li[8]")
    public WebElement tasks;

    @FindBy ( xpath = "//div[@class='header-menu unified-search']")
    public WebElement searchFiles;

    @FindBy ( xpath = "//div[@class='icon-contacts menutoggle']")
    public WebElement searchContacts;

    @FindBy ( id = "contactsmenu-search")
    public WebElement searchContactsInputBox;

    @FindBy ( xpath = "//div[@class='notifications']")
    public WebElement notifications;

    @FindBy ( id = "settings")
    public WebElement userSettings;

    @FindBy ( xpath = "//a[@class='active']")
    public WebElement activePage;

    public String getActivePageTitle() {
        //any time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForStaleElement(pageSubTitle);
        return activePage.getText();
    }
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(SkyDriver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
