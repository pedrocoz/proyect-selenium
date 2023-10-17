package step;

import org.junit.Assert;
import page.BasePage;
import page.GooglePage;
import page.NavigationPage;
import page.RegisterPage;

public class BaseSteps {
    NavigationPage navigatePage = new NavigationPage();
    GooglePage googlePage = new GooglePage();
    RegisterPage registerPage = new RegisterPage();

    public void openBrowser(){
        navigatePage.navigatePageUrl();
    }

    public void validateResult(String result){
        Assert.assertEquals(result, googlePage.resultSearch());
    }

    public void navigatePageRegister(){
        registerPage.navigatePage();
    }
}
