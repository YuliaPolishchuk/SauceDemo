package tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, priority = 1, alwaysRun = true, invocationCount = 2, timeOut = 2000,
            testName = "Авторизиция на сайте. Добавление товаров в корзину. Проверка отображаения товаров в корзине")
    @Description("Авторизиция на сайте. Добавление товаров в корзину. Проверка отображаения товаров в корзине")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("SauceDemo-1.0")
    @Feature("Website SauceDemo and cart")
    @Story("Авторизиция на сайте. Добавление товаров в корзину. Отображаение товаров в корзине")
    @TmsLink("www.jira.com/ITM-3")
    @Issue("www.jira.com/ITM-3")
    @Flaky
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

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "bkmemfnk", "Epic sadface: Username and password do not match any user in this service"},
                {"wrong_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "LoginData", retryAnalyzer = Retry.class, priority = 2, invocationCount = 2, timeOut = 2000,
            testName = "Проверка введения некорректного пароля")
    @Description("Проверка введения некорректного пароля")
    public void checkNegativeLogin(String user, String password, String massage) {
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login(user, password);
        softAssert.assertEquals(
                loginPage.getErrorMessage(),
                massage,
                "Сообщение об ошибке не появилось");
    }
}