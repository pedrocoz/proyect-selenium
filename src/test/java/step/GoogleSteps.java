package step;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.GooglePage;
import utils.ConfigManager;

public class GoogleSteps {
    private GooglePage googlePage = new GooglePage();


    public void searchText(String search){
       googlePage.writeSearch(search);
    }

    public void clickText(){
        googlePage.clickSearch();
    }
}
