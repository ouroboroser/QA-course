package com.reserved.landing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LandingTest {
    public static LandingPageTest orderingProcessPage;
    public WebDriver driver;

    private static final String URL = "https://www.reserved.com/ua/uk/";
    private static final String URL_UK_VERSION = "https://www.reserved.com/gb/en/";
    private static final String INCORRECT_EMAIL = "wrong email";
    private static final String URL_SUB = "https://www.reserved.com/ua/uk/subscription/";

    @BeforeEach
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        orderingProcessPage = new LandingPageTest(driver);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void changeLanguage() {
        orderingProcessPage.clickLanguageBtn();
        orderingProcessPage.clickEnglishBtn();
        orderingProcessPage.redirectEnglishVersion();

        String title = driver.getCurrentUrl();
        Assert.assertTrue(title.equals(URL_UK_VERSION));
        driver.quit();
    }

    @Test
    public void mailing() {
        orderingProcessPage.inputEmail(INCORRECT_EMAIL);
        orderingProcessPage.clickMailingBtn();
        orderingProcessPage.redirectSubPage();

        String title = driver.getCurrentUrl();
        Assert.assertTrue(title.equals(URL_SUB));
        driver.quit();
    }
}
