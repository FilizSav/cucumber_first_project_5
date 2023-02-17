package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.GoogleSearchPage;
import utilities.Driver;


public class GoogleSteps {


    WebDriver driver;
    GoogleSearchPage googleSearchPage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        googleSearchPage = new GoogleSearchPage();
    }
    @When("user search for {string}")
    public void user_search_for(String key) {
        System.out.println(key);
        googleSearchPage.searchInputBox.sendKeys(key + Keys.ENTER);
    }

    @Then("user should see {string} in the url")
    public void user_should_see_in_the_url(String key) {
        Assert.assertTrue(driver.getCurrentUrl().contains(key));
    }

    @Then("user should see {string} in the title")
    public void user_should_see_in_the_title(String key) {
        Assert.assertTrue(driver.getTitle().contains(key));
    }

    @Then("user should see results are more than {int}")
    public void userShouldSeeResultsAreMoreThan(int results) {
     Assert.assertTrue(Long.parseLong(googleSearchPage.results.getText().split(" ")[1].replaceAll(",",""))> results);
    }
}
