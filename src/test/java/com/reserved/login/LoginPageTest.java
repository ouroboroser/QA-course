package com.reserved.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String CORRECT_LOGIN_TITLE = "https://www.reserved.com/ua/uk/checkout/cart/";
    private static final String NEW_CORRECT_LOGIN_TITLE = "https://www.reserved.com/ua/uk/";
    private static final String LOGIN_TITLE = "https://www.reserved.com/ua/uk/customer/account/login/#login";

    public LoginPageTest(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    @FindBy(xpath = "//*[@id=\"headerWrapper\"]/div/div[2]/button[1]")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"loginRegisterRoot\"]/div/div[1]/div/form/button")
    private WebElement confirmLoginBtn;

    @FindBy(xpath = "/html/body/div[4]/div/div[2]/form/button")
    private WebElement sendEmailBtn;

    @FindBy(css = "#loginRegisterRoot > div > div.sc-hEsumM.eZyXBF > div > button")
    private WebElement forgotPasswordBtn;

    @FindBy(xpath = "//*[@id=\"loginRegisterRoot\"]/div/div[1]/div/div")
    private WebElement errorMessage;

    @FindBy(id = "login[username]_id")
    private WebElement fieldLogin;

    @FindBy(id = "login[password]_id")
    private WebElement fieldPassword;

    @FindBy(id = "email_id")
    private WebElement fieldForgotPassword;

    @FindBy(xpath = "//*[@id=\"cartRoot\"]/section/h1")
    private WebElement shopBlock;

    @FindBy(xpath = "/html/body/div[4]/div/div[2]/div")
    private WebElement modalWindow;


    public void clickLoginBtn() {
        loginBtn.click();
    }

    public void clickforgotPasswordBtn() {
        forgotPasswordBtn.click();
    }

    public void clickSendEmailBtn() {
        sendEmailBtn.click();
    }

    public void confirmLoginBtn() {
        confirmLoginBtn.click();
    }

    public void inputLogin(String login) {
        fieldLogin.sendKeys(login);
    }

    public void inputPassword(String password) {
        fieldPassword.sendKeys(password);
    }

    public void inputEmail(String email) {
        fieldForgotPassword.sendKeys(email);
    }

    public void check() {
        wait.until(ExpectedConditions.urlToBe(NEW_CORRECT_LOGIN_TITLE));
    }

    public void dontRedirect() {
        wait.until(ExpectedConditions.urlToBe(LOGIN_TITLE));
    }

    public void waitModalWindow() {
        wait.until(ExpectedConditions.visibilityOf(modalWindow));
    }
}
