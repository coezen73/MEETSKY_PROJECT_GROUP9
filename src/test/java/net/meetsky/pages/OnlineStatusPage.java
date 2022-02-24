package net.meetsky.pages;

import net.meetsky.utilities.SkyDriver;
import net.meetsky.utilities.SkyUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.Driver;

public class OnlineStatusPage extends BasePage {

    @FindBy(xpath = "//img[@src='/index.php/avatar/Employee1/32?v=21']")
    public WebElement userAvatar;

    @FindBy(xpath = "//a[@class='user-status-menu-item__toggle']")
    public WebElement statusMenuItem;

    @FindBy(xpath = "//div[@class='modal-container']")
    public WebElement modulContainer;

    @FindBy(xpath = "//input[@placeholder=\"What's your status?\"]")
    public WebElement statusTextBox;

    @FindBy(xpath = "//button[@class='status-buttons__primary primary']")
    public WebElement setStatusButton;

    public String expectedStatusMessage;

    public String option;

    public WebElement onlineStatusOption;

    public WebElement onlineStatusIcon;

    public WebElement preparedStatusOption;

    public String preparedStatusOptionText;


    public void navigateToStatusElement() {
        userAvatar.click();
        SkyUtils.waitFor(2);
        statusMenuItem.click();
    }

    public void navigateToAvatar() {
        userAvatar.click();

    }

    public void setOnlineStatusOption(String option) {
        this.option = option; //we are writing the status option as public to use later in verify
        String textPath = "//label[@for='user-status-online-status-" + option + "']";
        onlineStatusOption = SkyDriver.get().findElement(By.xpath(textPath));
        onlineStatusOption.click();
        try {
            onlineStatusIcon = SkyDriver.get().findElement(By.xpath("//span[@class='user-status-menu-item__toggle-icon icon-user-status-" + option + "']"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void findPreparedStatusOptionElement(String optionText) {

        String path = "//span[contains(text(),'" + optionText + "')] ";
        preparedStatusOption = SkyDriver.get().findElement(By.xpath(path));
        preparedStatusOptionText = optionText;

    }

}
