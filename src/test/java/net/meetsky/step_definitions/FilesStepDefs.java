package net.meetsky.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.pages.FilesPage;
import net.meetsky.pages.TalkModulePage;
import net.meetsky.utilities.SkyDriver;
import net.meetsky.utilities.SkyUtils;
import org.junit.Assert;


import java.util.List;

public class FilesStepDefs {
    FilesPage filesPage = new FilesPage();
    @When("user should be navigate the add icon module")
    public void user_should_be_navigate_the_add_icon_module() {
        SkyUtils.waitFor(1);
        filesPage.addIcon.click();
        SkyUtils.waitFor(3);
    }
    @Then("navigate to {string} button")
    public void navigate_to_button(String buttonName) {
        System.out.println("buttonName = " + buttonName);
        filesPage.navigate(buttonName);

    }

    @When("user should be able to click {string} button")
    public void user_should_be_able_to_click_button(String buttonName) {
        filesPage.newFolderButton.click();
    }

    @Then("user should be able to write {string} file name")
    public void user_should_be_able_to_write_file_name(String filename) {
        filesPage.newFolder.clear();
        filesPage.newFolder.sendKeys(filename);
        SkyUtils.waitFor(2);
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
        SkyUtils.waitFor(3);
        Assert.assertTrue(file.containsAll(file));


    }

}
