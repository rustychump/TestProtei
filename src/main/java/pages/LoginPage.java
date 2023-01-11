package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "loginEmail")
    private WebElement emailField;
    @FindBy(id = "loginPassword")
    private WebElement passwordField;
    @FindBy(id = "authButton")
    private WebElement loginButton;
    @FindBy(id = "invalidEmailPassword")
    private WebElement invalidEmailPasswordError;

    @Step("Заполнение поля ввода Email")
    public LoginPage setEmailField(String email){
        waitingWebElement(emailField);
        emailField.sendKeys(email);
        return this;
    }

    @Step("Заполнение поля ввода Пароль")
    public LoginPage setPasswordField(String password){
        waitingWebElement(passwordField);
        passwordField.sendKeys(password);
        return this;
    }

    @Step("клик по кнопке Вход")
    public LoginPage clickLoginButton(){
        waitingWebElement(loginButton);
        loginButton.click();
        return this;
    }

    @Step("Авторизация на странице")
    public FormPage login(String email, String password){
        setEmailField(email).setPasswordField(password).clickLoginButton();
        return new FormPage(driver);
    }

    @Step("Проверка открытия оповещения \"Неверный E-Mail или пароль\"")
    public boolean checkAlertWithIncorrectEmailPassword(){
        waitingWebElement(invalidEmailPasswordError);
        return invalidEmailPasswordError.isDisplayed();
    }
}