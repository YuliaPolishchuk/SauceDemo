package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductsTest extends BaseTest {

    @Test
    public void checkLoginPasswordWithWell() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        softAssert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "Логин не выполнен");
        productsPage.click();
        softAssert.assertEquals(
                productsPage.getRemove(),
                "Remove",
                "Add to cart");
        yourCart.open();
        softAssert.assertEquals(
                yourCart.getTitle(),
                "Your Cart",
                "Products");
        softAssert.assertEquals(
                yourCart.getShoppingCartBadge(),
                "1",
                "");
        softAssert.assertEquals(
                yourCart.getInventoryItemName(),
                "Sauce Labs Backpack",
                "");
        softAssert.assertAll();
    }
}