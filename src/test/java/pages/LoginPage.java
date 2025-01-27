package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userField = By.xpath("//input[@id='user-name']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//input[@id='login-button']");
    By errorMessage = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы LoginPage")
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Авторизация на сайте с логином {user} и паролем {password}")
    public void login(String user, String password) {
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Проверка введения некорректного пароля")
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
