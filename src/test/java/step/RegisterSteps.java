package step;

import org.junit.Assert;
import page.RegisterPage;

public class RegisterSteps {

    RegisterPage registerPage = new RegisterPage();

    public void ingresoDatosCuenta(){
        registerPage.accountDetails("","","","");
    }

    public void ingresarUsuario(String usuario){
        registerPage.ingresarUsuario(usuario);
    }

    public void ingresarEmail(String correo){
        registerPage.ingresarCorreo(correo);
    }

    public void ingresarContraseña(String contraseña){
        registerPage.ingresarContraseña(contraseña);
    }

    public void ingresarConContraseña(String contraseña){
        registerPage.ingresarCoContraseña(contraseña);
    }

    public void personalDetail(String nombre, String apellido, String celular){
        registerPage.personalDetails(nombre, apellido, celular);
    }

    public void adressPerson(String pais, String ciudad, String direccion, String provincia, String codigo){
        registerPage.address(pais,ciudad,direccion,provincia,codigo);
    }

    public void termsAndCondition(){
        registerPage.termsAndCondition();
    }

    public void registerAccount(){
        registerPage.registerAccount();
    }

    public void validateResult(){
        Assert.assertTrue("Usuario no existe",registerPage.validateExistUser());
    }

    public void validateText(String text){
        System.out.println(text+" texto esperado");
        System.out.println(registerPage.validateText()+" Texto actual");
        Assert.assertEquals(text,registerPage.validateText());
    }
}
