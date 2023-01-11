package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    @FindBy(id = "emailFormatError")
    protected WebElement emailFormatError;

    protected void waitingWebElement(WebElement webElement){
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(webElement));
    }

    @Step("Проверка открытия оповещения \"Неверный формат E-Mail\"")
    public boolean checkAlertWithIncorrectEmailFormat(){
        waitingWebElement(emailFormatError);
        return emailFormatError.isDisplayed();
    }
}
