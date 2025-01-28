package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourCart {

    WebDriver driver;

    By shoppingCartLink = By.cssSelector("[data-test=shopping-cart-link]");
    By title = By.cssSelector("[data-test=title]");
    By shoppingCartBadge = By.cssSelector("[data-test=shopping-cart-badge]");
    By inventoryItemName = By.cssSelector("[data-test=inventory-item-name]");

    public YourCart(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажатие на кнопку корзины")
    public void open() {
        driver.findElement(shoppingCartLink).click();
    }

    @Step("Проверка открытия страницы Your Cart")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Проверка отображения количества добавленного товара на значке корзины")
    public String getShoppingCartBadge() {
        return driver.findElement(shoppingCartBadge).getText();
    }

   @Step("Проверка отображения добавленного товара по наименованию на странице")
    public String getInventoryItemName() {
        return driver.findElement(inventoryItemName).getText();
    }
}
