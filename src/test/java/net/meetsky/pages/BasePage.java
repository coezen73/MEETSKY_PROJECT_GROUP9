package net.meetsky.pages;


import net.meetsky.utilities.SkyUtils;
import net.meetsky.utilities.SkyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;




public abstract class  BasePage {



    public BasePage() {

        PageFactory.initElements(SkyDriver.get(), this);
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
