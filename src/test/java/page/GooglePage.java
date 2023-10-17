package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigManager;

import java.time.Duration;

public class GooglePage extends BasePage{
    @FindBy(id = "APjFqb")
    public WebElement txtSearch;
    @FindBy(name = "btnK")
    public WebElement btnSearch;

    @FindBy(xpath = "//h2[@data-attrid='title']")
    public WebElement txtResult;

    public GooglePage() {
        super(driver);
    }

    public void writeSearch(String search){
        writeToElememt(txtSearch,search);
    }

    public void clickSearch(){
        clickElement(btnSearch);
    }
    public String resultSearch(){
       return getTotext(txtResult);
    }

}
