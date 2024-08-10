package com.nttdata.stepsdefinitions;


import com.nttdata.steps.StoreSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class StoreStepsDef {
    private WebDriver driver;



    @Dado("estoy en la página de la tienda")
    public void que_me_encuentro_en_la_página_de_login_de_sacedemo() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/iniciar-sesion");
        screenShot();
    }


    @Y("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        StoreSteps loginSteps = new StoreSteps(driver);
        loginSteps.typeUser(usuario);
        loginSteps.typePassword(clave);
        loginSteps.login();
        screenShot();
    }

    @Cuando("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        StoreSteps navigateSteps = new StoreSteps(driver);
        navigateSteps.category(categoria);
        navigateSteps.subcategoria(subcategoria);
        screenShot();
    }

    @Y("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades) {
        StoreSteps quantitySteps = new StoreSteps(driver);
        quantitySteps.cantidad(unidades);
        screenShot();
    }

    @Entonces("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        StoreSteps validateConfirmation = new StoreSteps(driver);
        validateConfirmation.validate();
        screenShot();
    }

    @Y("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        StoreSteps validatePrice = new StoreSteps(driver);
        validatePrice.getPrice();


    }

    @Cuando("finalizo la compra")
    public void finalizoLaCompra() {
        StoreSteps buyStep = new StoreSteps(driver);
        buyStep.buy();
    }

    @Entonces("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        StoreSteps validateTitle = new StoreSteps(driver);
        validateTitle.validateTitle();
        screenShot();
    }

    @Y("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        StoreSteps validatePrice = new StoreSteps(driver);
        validatePrice.validateCantidad();
    }

}
