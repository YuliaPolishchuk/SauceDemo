package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCart;
import utils.TestListener;

import java.time.Duration;

import static utils.AllureUtils.takeScreenshot;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    YourCart yourCart;

//    @Parameters({"browser"})
    @BeforeMethod
    public void setup() {
//        if(browser.equalsIgnoreCase("chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//            driver = new ChromeDriver(options);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        } else if (browser.equalsIgnoreCase("yandex")) {
//            driver = new YandexDriver();
//        }
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCart = new YourCart(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(driver);
        }
        driver.quit();
    }
}