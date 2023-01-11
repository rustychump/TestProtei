package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends BasePage {
    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "dataEmail")
    private WebElement emailField;
    @FindBy(id = "dataName")
    private WebElement nameField;
    @FindBy(id = "dataGender")
    private WebElement genderSelector;
    @FindBy(id = "dataCheck11")
    private WebElement option11Checkbox;
    @FindBy(id = "dataCheck12")
    private  WebElement option12Checkbox;
    @FindBy(id = "dataSelect21")
    private WebElement option21RadioButton;
    @FindBy(id = "dataSelect22")
    private WebElement option22RadioButton;
    @FindBy(id = "dataSelect23")
    private WebElement option23RadioButton;
    @FindBy(id = "dataSend")
    private WebElement addButton;
    @FindBy(css = ".uk-margin.uk-modal-content")
    private WebElement addDataAlert;
    @FindBy(id = "blankNameError")
    private WebElement blankNameError;
    @FindBy(css = ".uk-button.uk-button-primary.uk-modal-close")
    private WebElement okButton;

    @Step("Проверка открытия страницы с формой")
    public boolean checkOpenFormPage() {
        waitingWebElement(addButton);
        return addButton.isDisplayed();
    }

    @Step("Заполнение поля ввода Email")
    public FormPage setEmailField(String email){
        waitingWebElement(emailField);
        emailField.sendKeys(email);
        return this;
    }

    @Step("Заполнение поля ввода Имя")
    public FormPage setNameField(String name){
        waitingWebElement(nameField);
        nameField.sendKeys(name);
        return this;
    }

    @Step("Выбор варианта из выпадающего списка Пол")
    public FormPage selectGenderFromSelector(String gender){
        waitingWebElement(genderSelector);
        try {
            Select drpGender = new Select(genderSelector);
            drpGender.selectByVisibleText(gender);
        } catch (NoSuchElementException e) {
            return this;
        }
        return this;
    }

    @Step("Выбор чекбокса")
    public FormPage selectCheckbox(String option){
        waitingWebElement(option11Checkbox);
        if(getParent(option11Checkbox).getText().contains(option) & !option.isEmpty()){
            option11Checkbox.click();
        } else if(getParent(option12Checkbox).getText().contains(option) & !option.isEmpty()){
            option12Checkbox.click();
        } else if((((getParent(option11Checkbox).getText()+getParent(option12Checkbox).getText()).contains(option))  & !option.isEmpty()) || (((getParent(option12Checkbox).getText()+getParent(option11Checkbox).getText()).contains(option))  & !option.isEmpty())){
            option11Checkbox.click();
            option12Checkbox.click();
        }
        return this;
    }

    @Step("Выбор радиокнопки")
    public FormPage selectRadioButton(String option){
        waitingWebElement(option21RadioButton);
        if(getParent(option21RadioButton).getText().contains(option) & !option.isEmpty()){
            option21RadioButton.click();
        }else if(getParent(option22RadioButton).getText().contains(option) & !option.isEmpty()){
            option22RadioButton.click();
        }else if(getParent(option23RadioButton).getText().contains(option) & !option.isEmpty()){
            option23RadioButton.click();
        }
        return this;
    }

    @Step("Клик по кнопке Добавить")
    public FormPage clickAddButton(){
        waitingWebElement(addButton);
        addButton.click();
        return this;
    }

    public WebElement getParent(WebElement webElement){
        return webElement.findElement(By.xpath("./parent::div"));
    }

    @Step("Проверка добавления данных")
    public boolean checkAddData(){
        waitingWebElement(addDataAlert);
        return addDataAlert.isDisplayed();
    }

    @Step("Проверка открытия оповещения о пустом поле Имя")
    public boolean checkAlertWithoutName(){
        waitingWebElement(blankNameError);
        return blankNameError.isDisplayed();
    }
}
