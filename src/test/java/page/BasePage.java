package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;

    private static Actions action;

    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.close();
    }
    private WebElement findElement(WebElement locator){
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void clickElement(WebElement locator){
        findElement(locator).click();
    }

    public void writeToElememt(WebElement locator, String textToWrite){
        findElement(locator).sendKeys(textToWrite);
    }

    public String getTotext(WebElement locator){
        return findElement(locator).getText();
    }

    public void selectFromDropdownByText(WebElement locator, String textToSelect){
        Select dropdown = new Select(findElement(locator));
        dropdown.selectByVisibleText(textToSelect);
    }

    public void doubleClick(WebElement locator){
        action.doubleClick(findElement(locator));
    }

    public void rightClick(WebElement locator){
        action.contextClick(findElement(locator));
    }

    public boolean elementIsDisplayed(WebElement locator){
        return findElement(locator).isDisplayed();
    }

}
