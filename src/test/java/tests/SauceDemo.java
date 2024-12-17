package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SauceDemo extends BaseTest {

    @Test
    public void checkLoginPasswordWithWell() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(
                productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
        productsPage.click();
        assertEquals(
                productsPage.getRemove(),
                "Remove",
                "Add to cart");
        yourCart.open();
        assertEquals(
                yourCart.getTitle(),
                "Your Cart",
                "Products");
        assertEquals(
                yourCart.getShoppingCartBadge(),
                "1",
                "");
        assertEquals(
                yourCart.getInventoryItemName(),
                "Sauce Labs Backpack",
                "");
    }
}