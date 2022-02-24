package net.meetsky.pages;

import net.meetsky.utilities.SkyDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage extends BasePage {
    public FilesPage() {
        PageFactory.initElements(SkyDriver.get(), this);
    }

    @FindBy(css = ".icon-add")
    public WebElement addIcon;

    @FindBy(xpath = "(//span[@class='displayname'])[1]")
    public WebElement upload;

    @FindBy(xpath = "(//span[@class='displayname'])[2]")
    public WebElement newFolderButton;

    @FindBy(xpath = "(//span[@class='displayname'])[3]")
    public WebElement newTextDocument;

    @FindBy(xpath = "(//input[@id='view13-input-folder'])[1]")
    public WebElement newFolder;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement confirm;

    @FindBy(xpath = "//*[@id='fileList']/tr")
    public List<WebElement> check;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement iucar;

    public void navigate(String buttonName) {
        switch (buttonName) {
            case "Upload file":
                new FilesPage().upload.click();
                break;
            case "New folder":
                new FilesPage().newFolderButton.click();
                break;
            case "New text document":
                new FilesPage().newTextDocument.click();
                break;
        }
    }
}



