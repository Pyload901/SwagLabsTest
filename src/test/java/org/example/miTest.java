package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class miTest {

    public WebDriver driver;

    public void setUp() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        edgeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.saucedemo.com");

        //loggin
        WebElement username = driver.findElement(By.cssSelector("#user-name"));
        WebElement password = driver.findElement(By.cssSelector("#password"));


        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        driver.findElement(By.cssSelector("#login-button")).click();

        //adding elements in cart
        WebElement element1 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        WebElement element2 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
        element1.click();
        element2.click();

        //remove element
        WebElement deleteButton = driver.findElement(By.cssSelector("#remove-sauce-labs-bike-light"));
        deleteButton.click();

        //navigate to cart registration
        WebElement cartButton = driver.findElement(By.cssSelector("#shopping_cart_container"));
        cartButton.click();

        //checkout
        driver.findElement(By.cssSelector("#checkout")).click();

        driver.quit();
    }

    @Test
    public void test() {
        setUp();
    }
}
