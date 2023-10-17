package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    @FindBy(id = "menuUserLink")
    public WebElement btnUser;
    @FindBy(css = ".create-new-account.ng-scope")
    public WebElement btnCreateNewUser;
    @FindBy(xpath = "//input[@name='usernameRegisterPage']")
    public WebElement txtUsername;
    @FindBy(xpath = "//input[@name='emailRegisterPage']")
    public WebElement txtEmail;
    @FindBy(xpath = "//input[@name='passwordRegisterPage']")
    public WebElement txtPassword;
    @FindBy(xpath = "//input[@name='confirm_passwordRegisterPage']")
    public WebElement txtConfirmPassword;
    @FindBy(xpath = "//input[@name='first_nameRegisterPage']")
    public WebElement txtFirstName;
    @FindBy(xpath = "//input[@name='last_nameRegisterPage']")
    public WebElement txtLastName;
    @FindBy(xpath = "//input[@name='phone_numberRegisterPage']")
    public WebElement txtPhoneNumber;
    @FindBy(xpath = "//select[@name='countryListboxRegisterPage']")
    public WebElement selectCountry;
    @FindBy(xpath = "//input[@name='cityRegisterPage']")
    public WebElement txtCity;
    @FindBy(xpath = "//input[@name='addressRegisterPage']")
    public WebElement txtAddress;
    @FindBy(xpath = "//input[@name='state_/_province_/_regionRegisterPage']")
    public WebElement txtProvince;
    @FindBy(xpath = "//input[@name='postal_codeRegisterPage']")
    public WebElement txtPostalCode;
    @FindBy(xpath = "//input[@name='i_agree']")
    public WebElement cbkTerms;
    @FindBy(id = "register_btn")
    public WebElement btnRegister;

    @FindBy(css = "label.smollMargin.invalid")
    public WebElement lblMessageUser;

    @FindBy(css = "span.hi-user.containMiniTitle.ng-binding")
    public WebElement lblUser;

    public RegisterPage() {
        super(driver);
    }

    public void navigatePage(){
        try{
            clickElement(btnUser);
            clickElement(btnCreateNewUser);
        }
        catch (Exception e){
            System.out.println("ERROR: Fallo la navegacion");
        }
    }

    public void accountDetails(String user,String email, String password, String confirmPassword){
        writeToElememt(txtUsername,user);
        writeToElememt(txtEmail,email);
        writeToElememt(txtPassword,password);
        writeToElememt(txtConfirmPassword,confirmPassword);
    }

    public void ingresarUsuario(String user){
        writeToElememt(txtUsername,user);
    }

    public void ingresarCorreo(String user){
        writeToElememt(txtEmail,user);
    }

    public void ingresarContraseña(String user){
        writeToElememt(txtPassword,user);
    }
    public void ingresarCoContraseña(String user){
        writeToElememt(txtConfirmPassword,user);
    }

    public void personalDetails(String nombre, String apellido, String celular){
        writeToElememt(txtFirstName,nombre);
        writeToElememt(txtLastName,apellido);
        writeToElememt(txtPhoneNumber,celular);
    }
    public void address(String pais, String ciudad, String direccion, String provincia, String codigo){
        selectFromDropdownByText(selectCountry,pais);
        writeToElememt(txtCity,ciudad);
        writeToElememt(txtAddress,direccion);
        writeToElememt(txtProvince,provincia);
        writeToElememt(txtPostalCode,codigo);
    }

    public void termsAndCondition(){
        clickElement(cbkTerms);
    }

    public void registerAccount(){
        clickElement(btnRegister);
    }
    public boolean validateExistUser(){
        return elementIsDisplayed(lblMessageUser);
    }

    public String validateText(){
        return getTotext(lblUser);
    }

}
