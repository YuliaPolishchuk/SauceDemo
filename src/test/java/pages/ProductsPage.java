package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    By title = By.cssSelector("[data-test=title]");
    By AddToCart = By.cssSelector("[data-test=add-to-cart-sauce-labs-backpack]");
    By remove = By.cssSelector("[data-test=remove-sauce-labs-backpack]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка открытия страницы Products")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Добавление в корзину товара Sauce Labs Backpack")
    public void click() {
        driver.findElement(AddToCart).click();
    }

    @Step("Отмена добавления товара Sauce Labs Backpack в корзину")
    public String getRemove() {
        return driver.findElement(remove).getText();
    }
}