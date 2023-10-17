package glue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import step.BaseSteps;
import step.RegisterSteps;

import java.util.List;
import java.util.Map;

public class StepDefinitionRegister {
    BaseSteps baseSteps = new BaseSteps();
    RegisterSteps registerSteps = new RegisterSteps();

    @Given("Ingreso a la pagina Advantage")
    public void open(){
        baseSteps.openBrowser();
    }

    @Given("navego a la pagina crear cuenta")
    public void navigation(){
        baseSteps.navigatePageRegister();
    }

    @When("Ingreso los detalles de mi cuenta")
    public void ingresoDetalleCuenta() {
        registerSteps.ingresoDatosCuenta();
    }

    @When("Ingreso el usuario {string}")
    public void ingreso_el_usuario(String usuario) {
        registerSteps.ingresarUsuario(usuario);
    }
    @When("Ingreso el correo {string}")
    public void ingreso_el_correo(String correo) {
        registerSteps.ingresarEmail(correo);
    }
    @When("Ingreso la contraseña {string}")
    public void ingreso_la_contraseña(String contraseña) {
        registerSteps.ingresarContraseña(contraseña);
    }
    @When("Ingreso la confirmacion de contraseña {string}")
    public void ingreso_la_confirmacion_de_contraseña(String contraseña) {
        registerSteps.ingresarConContraseña(contraseña);
    }

    @When("Ingreso mis datos personales")
    public void ingreso_mis_datos_personales(DataTable dataTable) {
        Map<String,String> data = dataTable.asMap(String.class,String.class);
        registerSteps.personalDetail(data.get("nombre"), data.get("apellido"),data.get("celular"));
    }

    @When("Ingreso el detalle de la cuenta v1")
    public void ingreso_el_detalle_de_la_cuenta_v1(DataTable dataTable) {
        System.out.println(dataTable);
        List<Map<String,String>> datas = dataTable.asMaps(String.class,String.class);
        System.out.println(datas);
        for (Map<String,String> data: datas) {
            registerSteps.ingresarUsuario(data.get("usuario"));
            registerSteps.ingresarEmail(data.get("correo"));
            registerSteps.ingresarContraseña(data.get("contraseña"));
            registerSteps.ingresarConContraseña(data.get("confirm-contraseña"));
        }
    }

    @When("Ingreso el detalle de la cuenta v2")
    public void ingreso_el_detalle_de_la_cuenta_v2(DataTable dataTable) {
        Map<String,String> data = dataTable.asMap(String.class,String.class);
        registerSteps.ingresarUsuario(data.get("usuario"));
        registerSteps.ingresarEmail(data.get("correo"));
        registerSteps.ingresarContraseña(data.get("contraseña"));
        registerSteps.ingresarConContraseña(data.get("confirm-contraseña"));
    }


    @When("Ingreso mi direccion")
    public void ingreso_mi_direccion(DataTable dataTable) {
        Map<String,String> data = dataTable.asMap(String.class,String.class);
        System.out.println(data);
        registerSteps.adressPerson(data.get("pais"),data.get("ciudad"), data.get("direccion"), data.get("provincia"), data.get("codigo-postal"));

    }
    @When("Accepto los terminos y condiciones")
    public void accepto_los_terminos_y_condiciones() {
        registerSteps.termsAndCondition();
    }
    @When("registro una cuenta")
    public void registro_una_cuenta() {
        registerSteps.registerAccount();
    }

    @Then("valido que exista el usuario")
    public void valido_que_exista_el_usuario() {
        registerSteps.validateResult();
    }

    @Then("valido que el usuario {string} este registrado")
    public void valido_que_el_usuario_este_registrado(String usuario) {
        registerSteps.validateText(usuario);
    }



}
