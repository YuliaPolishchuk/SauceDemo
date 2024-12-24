package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By userField = By.xpath("//input[@id='user-name']");
//    String userField = "//div[text()='Username']//ancestor::div[@class='login-box']//input"; не получилось с такими локатором сделать
    By passwordField = By.xpath("//input[@id='password']");
// String passwordField = "//div[text()='Password']//ancestor::div[@class='login-box']//input";
    By loginButton = By.xpath("//input[@id='login-button']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String user, String password) {
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

//    public void login(String user, String password) {
//        driver.findElement(By.xpath(String.format(userField, user))).sendKeys(user);
//        driver.findElement(By.xpath(String.format(passwordField, user))).sendKeys(password);
//        driver.findElement(loginButton).click();
//    }
}
