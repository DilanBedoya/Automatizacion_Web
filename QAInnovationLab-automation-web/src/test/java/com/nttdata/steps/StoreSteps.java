package com.nttdata.steps;

import com.nttdata.page.StorePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class StoreSteps {
    private WebDriver driver;

    public StoreSteps(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     *
     * @param user el usuario
     */
    public void typeUser(String user) {
        WebElement userInputElement = driver.findElement(StorePage.userInput);
        userInputElement.sendKeys(user);
        if (Objects.equals(user, "dilan.-bedoya@hotmail.com")){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); //validar que espere 40 segundos
            wait.until(ExpectedConditions.visibilityOfElementLocated(StorePage.loginButton)); //validar hasta que aparezca el elemento loginButton

        }else {
            Assertions.fail("El usuario proporcionado no es el esperado. Prueba abortada.");
        }


    }

    /**
     * Escribir el password
     *
     * @param password el password del usuario
     */
    public void typePassword(String password) {
        this.driver.findElement(StorePage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login() {
        this.driver.findElement(StorePage.loginButton).click();
    }


    /**
     * Escribir la categoria
     *
     * @param categoria la categoria
     */

    public void category(String categoria) {
        this.driver.findElement(StorePage.clothesButton).click();



        try {
            Thread.sleep(1000); // Espera de 1 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Escribir la subcategoria
     *
     * @param subcategoria la subcategoria
     */
    public void subcategoria(String subcategoria) {
        this.driver.findElement(StorePage.menButton).click();
        try {
            Thread.sleep(1000); // Espera de 1 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Escribir la catidad
     *
     * @param cantidad la cantidad a enviar
     */
    public void cantidad(int cantidad) {
        this.driver.findElement(StorePage.pageClothes).click();

        WebElement quantityField = this.driver.findElement(StorePage.quantity);

        // Limpia el campo de entrada y envía el valor numérico como texto
        quantityField.click();
        quantityField.sendKeys(Keys.CONTROL + "a"); // Selecciona el texto que este en el campo
        quantityField.sendKeys(Keys.BACK_SPACE); // Borra el texto seleccionado
        quantityField.sendKeys(String.valueOf(cantidad)); // se escribe la cantidad

        try {
            Thread.sleep(2000); // Espera de 2 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    //método para validar popup de producto agregado
    public void validate() {
        this.driver.findElement(StorePage.addCarButton).click();
        try {
            Thread.sleep(4000); // Espera de 4 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Obtener mensaje de validación
        WebElement title = driver.findElement(StorePage.validateCarButton);
        Assertions.assertEquals(title.getText(), "\uE876Producto añadido correctamente a su carrito de compra");

    }

    //método para validar
    public void getPrice() {

        WebElement price = driver.findElement(StorePage.getPrice);
        WebElement cantidad = driver.findElement(StorePage.getQuantity);


        String obtenerPrecio = price.getText();
        // Reemplazar caracteres no numéricos y las comas por una cadena vacía, pero mantener el punto decimal
        // En este caso, reemplazamos las comas por puntos para que sea compatible con el formato decimal de Java
        String soloNumeros = obtenerPrecio.replaceAll("[^\\d,]", "").replace(",", ".");

        // Convertir a float y obtener precio
        float precio = Float.parseFloat(soloNumeros);

        // Convertir a int y obtener cantidad
        String obtenerCantidad = cantidad.getText();
        int quantity = Integer.parseInt(obtenerCantidad);

        // validar que el monto total sea calculado correctamente
        float valorFinal = quantity * precio;
        String valorConComa = String.valueOf(valorFinal).replace(".", ",");

        // validar y comparar con el total de la página
        WebElement comparar = driver.findElement(StorePage.getTotal);
        Assertions.assertEquals(comparar.getText(), String.valueOf(valorConComa) + " PEN");


    }

    public void buy() {
        this.driver.findElement(StorePage.buy).click();
        try {
            Thread.sleep(3000); // Espera de 3 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void validateTitle() {

        //Validación del titulo de carrito
        WebElement title = driver.findElement(StorePage.validateTitle);
        Assertions.assertEquals(title.getText(), "CARRITO");

    }

    public void validateCantidad() {

        WebElement price = driver.findElement(StorePage.getPriceCar);
        WebElement cantidad = driver.findElement(StorePage.getQuantityCar);


        String obtenerPrecio = price.getText();
        // Reemplazar caracteres no numéricos y las comas por una cadena vacía, pero mantener el punto decimal
        // En este caso, reemplazamos las comas por puntos para que sea compatible con el formato decimal de Java
        String soloNumeros = obtenerPrecio.replaceAll("[^\\d,]", "").replace(",", ".");

        // Convertir a float y obtener precio
        float precio = Float.parseFloat(soloNumeros);


        // Convertir a int y obtener cantidad con atributo
        String obtenerCantidad = cantidad.getAttribute("value");
        int quantity = Integer.parseInt(obtenerCantidad);


        // validar que el monto total sea calculado correctamente
        float valorFinal = quantity * precio;
        String valorConComa = String.valueOf(valorFinal).replace(".", ",");


        // validar y comparar con el precio total de la página

        WebElement comparar = driver.findElement(StorePage.validatePrice);
        System.out.println(comparar.getText());

        Assertions.assertEquals(comparar.getText(), String.valueOf(valorConComa) + " PEN");


    }


}
