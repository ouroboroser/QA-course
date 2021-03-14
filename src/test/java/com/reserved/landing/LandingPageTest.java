package com.reserved.landing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String URL_UK_VERSION = "https://www.reserved.com/gb/en/";
    private static final String URL_SUB = "https://www.reserved.com/ua/uk/subscription/";

    public LandingPageTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    @FindBy(xpath = "/html/body/footer/div[1]/div/div/ul/div/ul/li[1]/ul/li[9]/a")
    private WebElement changeLanguageBtn;

    @FindBy(xpath = "/html/body/main/ul/li[22]/a")
    private WebElement clickEnglishBtn;

    @FindBy(xpath = "/html/body/footer/div[1]/div/div/ul/li[1]/div/div/form/div[1]/label/input")
    private WebElement fieldMailing;

    @FindBy(xpath = "/html/body/footer/div[1]/div/div/ul/li[1]/div/div/form/button")
    private WebElement mailingBtn;

    public void clickLanguageBtn() {
        changeLanguageBtn.click();
    }

    public void clickEnglishBtn() {
        clickEnglishBtn.click();
    }

    public void clickMailingBtn() {
        mailingBtn.click();
    }

    public void redirectEnglishVersion() {
        wait.until(ExpectedConditions.urlToBe(URL_UK_VERSION));
    }

    public void inputEmail(String email) {
        fieldMailing.sendKeys(email);
    }


    public void redirectSubPage() {
        wait.until(ExpectedConditions.urlToBe(URL_SUB));
    }
}
