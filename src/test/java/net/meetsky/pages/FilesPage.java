package net.meetsky.pages;

import gherkin.lexer.Fi;
import net.meetsky.utilities.SkyDriver;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//span[@class='innernametext' and contains(.,'HelloMeetSky')]")
    public WebElement helloSky;

    @FindBy(xpath = "//tbody[@id='fileList']//input[@type='checkbox']")
    public List<WebElement> checkBoxes;

    @FindBy(css = "[for='select-files-22216']")
    public WebElement getCheckBox2;

    @FindBy(css = "[for='select-files-22208']")
    public WebElement getCheckBox3;

    @FindBy(id = "fileList")
    public List<WebElement> fileList;

   @FindBy(xpath = "(//a[@class='actions-selected'])[1]")
   public WebElement actionsListButton;

   @FindBy(xpath = "(//li[@class='item-delete'])[1]")
   public WebElement deleteButton;

   @FindBy(xpath = "//tr[@data-file='MARK.docx']//td//label")
   public WebElement fileMark;

   @FindBy (xpath = "//a[@href='/index.php/apps/files/']")
   public WebElement navigateFileButton;

   @FindBy (xpath = "//table[@id='filestable']/tbody/tr")
   public List<WebElement> checkfileList;


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
            case "fileMark":
                new FilesPage().fileMark.click();
                break;
            case "Actions":
                new FilesPage().actionsListButton.click();
                break;
            case"Delete":
                new FilesPage().deleteButton.click();
                break;

        }
    }

    public  void selectCheckBox(String str){
        SkyDriver.get().findElement(By.xpath("//tr[@data-file='" + str + "']//td//label")).click();
        System.out.println("SkyDriver.get().findElement(By.xpath(\"//tr[@data-file='\" + str + \"']//td//label\")).getText() " +
                " = " + SkyDriver.get().findElement(By.xpath("//tr[@data-file='" + str + "']//td//label")).getText());
    }

}



