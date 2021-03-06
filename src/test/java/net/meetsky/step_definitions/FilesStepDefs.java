package net.meetsky.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.pages.FilesPage;
import net.meetsky.pages.TalkModulePage;
import net.meetsky.utilities.SkyDriver;
import net.meetsky.utilities.SkyUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.Collections;
import java.util.List;

public class FilesStepDefs {
    FilesPage filesPage = new FilesPage();
    @When("user should be click the add icon module")
    public void user_should_be_click_the_add_icon_module() {
        SkyUtils.waitFor(1);
        filesPage.addIcon.click();
        SkyUtils.waitFor(3);
    }

    @Then("user should be able to click {string} button")
    public void user_should_be_able_to_click_button(String buttonName) {
        SkyUtils.waitFor(3);
        filesPage.navigate(buttonName);
        SkyUtils.waitFor(2);

    }

    @Then("user should be able to write {string} file name")
    public void user_should_be_able_to_write_file_name(String filename) {
        filesPage.fileSendKeys(filename);

    }
    @When("user should be able to click file button")
    public void user_should_be_able_to_click_file_button() {
        filesPage.selectCheckBox("HelloMeetSky.docx");
        SkyUtils.waitFor(3);
    }

    @Then("user should be able to click confirm icon")
    public void user_should_be_able_to_click_confirm_icon() {
          filesPage.confirm.click();
          SkyUtils.waitFor(2);
          SkyDriver.get().navigate().refresh();
    }

        @Then("verify new {string} file is shown on the page")
    public void verify_new_file_is_shown_on_the_page(String filename) {

        List<String> file = SkyUtils.getElementsText(filesPage.check);
            for (String s : file) {
                System.out.println(s);

            }
        SkyUtils.waitFor(3);
        Assert.assertEquals(filename,SkyDriver.get().findElement(By.xpath("//span[@class='innernametext' and contains(.,'"+filename+"')]")).getText());




    }
    @Then("verify that Actions button is appeared")
    public void verify_that_Actions_button_is_appeared() {
        filesPage.actionsListButton.click();
        SkyUtils.waitFor(2);
        Assert.assertTrue( filesPage.actionsListButton.isEnabled());
    }

    @Then("verify that the file is deleted")
    public void verify_that_the_file_is_deleted() {
        SkyDriver.get().navigate().refresh();
        SkyUtils.waitFor(3);

      // Assert.assertFalse(filesPage.fileMark.isDisplayed());

    }

    @When("user should be able to click {string} buttons")
    public void user_should_be_able_to_click_buttons(String string) {

        filesPage.navigate(string);
        SkyUtils.waitFor(3);

    }
    @Then("user should be able to click delete buttons")
    public void user_should_be_able_to_click_delete_buttons() {
        filesPage.deleteButton.click();
        SkyUtils.waitFor(2);
    }

    @Then("verify that the file is deleteds")
    public void verify_that_the_file_is_deleteds() {
        List<String> file = SkyUtils.getElementsText(filesPage.check);
        SkyUtils.waitFor(3);
        Assert.assertFalse(file.contains("HelloMeetSky.docx"));

    }
    @Then("user should be able to upload {string} file name")
    public void user_should_be_able_to_upload_file_name(String string) {
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/HelloMeetSky.docx";
        String fullPath =  projectPath+"/"+filePath;
        System.out.println(fullPath);

        SkyDriver.get().findElement(By.xpath("//input[@type='file']")).sendKeys(fullPath);
        SkyUtils.waitFor(10);
       // SkyDriver.get().findElement(By.xpath("//input[@type='file']")).click();
        SkyDriver.get().navigate().refresh();



    }

}
