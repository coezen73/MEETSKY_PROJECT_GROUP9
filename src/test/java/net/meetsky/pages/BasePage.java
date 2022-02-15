package net.meetsky.pages;


import net.meetsky.utilities.SkyUtils;
import net.meetsky.utilities.SkyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class  BasePage {

    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;

    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    public BasePage() {
        PageFactory.initElements(SkyDriver.get(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(SkyDriver.get(), 5);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getUserName(){
        waitUntilLoaderScreenDisappear();
        SkyUtils.waitForVisibility(userName, 5);
        return userName.getText();
    }



    public void logOut(){
        SkyUtils.waitFor(2);
        SkyUtils.clickWithJS(userName);
        SkyUtils.clickWithJS(logOutLink);
    }
    public void goToMyUser(){
        waitUntilLoaderScreenDisappear();
        SkyUtils.waitForClickablility(userName, 5).click();
        SkyUtils.waitForClickablility(myUser, 5).click();

    }

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module) {
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        try {
            SkyUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = SkyDriver.get().findElement(By.xpath(tabLocator));
            new Actions(SkyDriver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            SkyUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            SkyUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            SkyUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            SkyUtils.scrollToElement(SkyDriver.get().findElement(By.xpath(moduleLocator)));
            SkyDriver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            SkyUtils.clickWithTimeOut(SkyDriver.get().findElement(By.xpath(moduleLocator)),  5);
        }
    }

}
