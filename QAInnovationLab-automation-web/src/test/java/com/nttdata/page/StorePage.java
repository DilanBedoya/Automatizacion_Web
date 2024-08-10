package com.nttdata.page;

import org.openqa.selenium.By;

public class StorePage {
    //pages para el login
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");

    //pages luego del login
    public static By clothesButton = By.xpath("//*[@id=\"category-3\"]/a");
    public static By menButton = By.xpath("//*[@id=\"left-column\"]/div[1]/ul/li[2]/ul/li[1]/a");
    public static By pageClothes = By.xpath("//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img");

    //Especificar cantidad
    public static By quantity = By.xpath("//*[@id=\"quantity_wanted\"]");

    //Añadir al carrito y validar popup
    public static By addCarButton = By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button");
    public static By validateCarButton = By.xpath("//*[@id=\"myModalLabel\"]");

    //Obtener valores de popup y validar monto con total de la pagina
    public static By getPrice = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/p");
    public static By getQuantity = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[1]/div/div[2]/span[3]/strong");
    public static By getTotal = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/p[4]/span[2]");

    //Pasar a la pagina de finalizar compra, validar titulo y precios
    public static By buy = By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a");
    public static By validateTitle = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[1]/h1");
    public static By getPriceCar = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span");
    public static By getQuantityCar = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[1]/div/input");

    public static By validatePrice = By.xpath("//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[3]/div/div[2]/div/div[2]/span");


}
