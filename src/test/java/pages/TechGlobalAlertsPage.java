package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalAlertsPage extends TechGlobalBasePage {
    public TechGlobalAlertsPage() {super();}

    @FindBy(id = "action")
    public WebElement results;
    @FindBy(css = "#result_id")
    public WebElement resultsText;
    @FindBy(id = "main_heading")
    public WebElement heading;
    @FindBy(css = "li button")
    public List<WebElement> alertButtons;



    public void clickOnAlert(String test){
        for( WebElement alert : alertButtons){
            if(alert.getText().equals(test)){
                alert.click();
                break;
            }
        }
    }
}
