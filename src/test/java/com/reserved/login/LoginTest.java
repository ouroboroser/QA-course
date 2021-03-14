package com.reserved.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    public static LoginPageTest loginPage;
    public WebDriver driver;

    private static final String URL = "https://www.reserved.com/ua/uk/";
    private static final String LOGIN_TITLE = "https://www.reserved.com/ua/uk/customer/account/login/#login";
    private static final String CORRECT_LOGIN_TITLE = "https://www.reserved.com/ua/uk/checkout/cart/";
    private static final String NEW_CORRECT_LOGIN_TITLE = "https://www.reserved.com/ua/uk/";

    private static final String EMAIL = "focek33547@leonvero.com";
    private static final String PASSWORD = "focek33547@leonvero.com";
    private static final String INCORRECT_PASSWORD = "wrong password";

    @BeforeEach
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        loginPage = new LoginPageTest(driver);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void loginCorrectData() {
        loginPage.clickLoginBtn();
        loginPage.inputLogin(EMAIL);
        loginPage.inputPassword(PASSWORD);
        loginPage.confirmLoginBtn();
        loginPage.check();

        String title = driver.getCurrentUrl();
        Assert.assertTrue(title.equals(NEW_CORRECT_LOGIN_TITLE));
        driver.quit();
    }

    @Test
    public void loginInCorrectData() {
        loginPage.clickLoginBtn();
        loginPage.inputLogin(EMAIL);
        loginPage.inputPassword(INCORRECT_PASSWORD);
        loginPage.confirmLoginBtn();
        loginPage.dontRedirect();

        String title = driver.getCurrentUrl();
        Assert.assertTrue(title.equals(LOGIN_TITLE));
        driver.quit();
    }

    @Test
    public void restorePassword() {
        loginPage.clickLoginBtn();
        loginPage.clickforgotPasswordBtn();
        loginPage.inputEmail(EMAIL);
        loginPage.clickSendEmailBtn();
        loginPage.waitModalWindow();
        driver.quit();
    }
}
