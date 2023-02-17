package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalAlertsPage;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendTestingHomePage;
import utilities.AlertHandler;
import utilities.Driver;
import utilities.Waiter;


public class TechGlobalSteps {
    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalAlertsPage techGlobalAlertsPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalDynamicTablesPage= new TechGlobalDynamicTablesPage();
        techGlobalAlertsPage = new TechGlobalAlertsPage();

    }

    @When("user clicks on Practices dropdown in the header")
    public void userClicksOnPracticesDropdownInTheHeader() {
        techGlobalFrontendTestingHomePage.headerDropdown.click();
    }

    @And("user selects the {string} option")
    public void userSelectsTheOption(String option) {
        switch (option) {
            case "Frontend Testing":
                techGlobalFrontendTestingHomePage.headerDropdownOptions.get(0).click();
                break;
            case "Alerts":
            case "Dynamic Tables":
            case "Login Form":
                techGlobalFrontendTestingHomePage.clickOnCard(option);
                break;
            default:
                throw new NotFoundException();
        }
    }


    @When("user clicks the {string} button")
    public void userClicksTheButton(String argument) {
        switch (argument){
            case "ADD PRODUCT":
                techGlobalDynamicTablesPage.addProductButton.click();
                break;
            case "CLOSE":
                techGlobalDynamicTablesPage.closeButton.click();
                break;
            default:
                throw new NotFoundException("The button text is not defined properly in the feature file");
        }
    }

    @Then("validate {string} pop-up is displayed")
    public void validatePopUpIsDisplayed(String popup) {
        Assert.assertEquals(popup, techGlobalDynamicTablesPage.modalCardTitle.getText());
    }

    @Then("user should not see Add New Product pop-up")
    public void userShouldNotSeeAddNewProductPopUp() {
        try {
            Assert.assertFalse(techGlobalDynamicTablesPage.modalCardTitle.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

    @Then("user should see {string} headings")
    public void userShouldSeeHeadings(String headerText) {
        switch (headerText) {
            case "Dynamic Tables":
                Assert.assertEquals(headerText, techGlobalDynamicTablesPage.headingText.getText());
                break;
            case "Alerts":
                Assert.assertEquals(headerText,techGlobalAlertsPage.heading.getText());
                break;
            default: throw new NotFoundException("Heading not defined in feature file");
        }
    }

    @And("user should see buttons as {string}, {string}, and {string}")
    public void userShouldSeeButtonsAsAnd(String alert1, String alert2, String alert3) {
        for (int i = 0; i < techGlobalAlertsPage.alertButtons.size(); i++) {
            Assert.assertTrue(techGlobalAlertsPage.alertButtons.get(i).isDisplayed());}
            Assert.assertEquals(alert1,techGlobalAlertsPage.alertButtons.get(0).getText());
            Assert.assertEquals(alert2,techGlobalAlertsPage.alertButtons.get(1).getText());
            Assert.assertEquals(alert3,techGlobalAlertsPage.alertButtons.get(2).getText());
    }

    @And("user should see {string} texts")
    public void userShouldSeeTexts(String resultText) {
        driver.switchTo();
        Assert.assertEquals(resultText, techGlobalAlertsPage.resultsText.getText());
    }

    @When("user clicks on {string} box")
    public void userClicksOnBox(String alertButton) {
        techGlobalAlertsPage.clickOnAlert(alertButton);
    }

    @Then("user should see a popup displaying messages {string}")
    public void userShouldSeeAPopupDisplayingMessage(String alertMessage) {
        Waiter.pause(2);
        Assert.assertEquals(alertMessage, AlertHandler.getAlertText());
        Waiter.pause(2);
        AlertHandler.acceptAlert();
    }
    @When("user clicks on {string} dropdown in the header")
    public void user_clicks_on_dropdown_in_the_header(String string) {

    }

    @When("user selects the {string} card")
    public void user_selects_the_card(String string) {

    }

    @When("user enters username  {string} and password  {string}")
    public void user_enters_username_and_password(String string, String string2) {

    }

    @Then("user should see a {string} message")
    public void user_should_see_a_message(String string) {

    }
}