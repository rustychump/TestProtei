import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

public class FormPageTests extends BaseTest {

    private final String NAME = "name";

    @DisplayName("Тест на проверку попытки добавить данные с неекорректным форматом Email")
    @Test
    public void addDataWithIncorrectEmailFormat(){
        Assert.assertTrue(new LoginPage(driver)
                .login(EMAIL, PASSWORD)
                .setEmailField(INCORRECT_EMAIL_FORMAT)
                .setNameField(NAME)
                .clickAddButton()
                .checkAlertWithIncorrectEmailFormat());
    }

    @DisplayName("Тест на проверку попытки добавить данные без Email")
    @Test
    public void addDataWithoutEmail(){
        Assert.assertTrue(new LoginPage(driver)
                .login(EMAIL, PASSWORD)
                .setEmailField("")
                .setNameField(NAME)
                .clickAddButton()
                .checkAlertWithIncorrectEmailFormat());
    }

    @DisplayName("Тест на проверку попытки добавить данные без Имени")
    @Test
    public void addDataWithoutName(){
        Assert.assertTrue(new LoginPage(driver)
                .login(EMAIL, PASSWORD)
                .setEmailField(EMAIL)
                .setNameField("")
                .clickAddButton()
                .checkAlertWithoutName());
    }

    @DisplayName("Тест на проверку попытки добавить данные без Email и Имени")
    @Test
    public void addDataWithoutEmailAndName(){
        Assert.assertTrue(new LoginPage(driver)
                .login(EMAIL, PASSWORD)
                .setEmailField("")
                .setNameField("")
                .clickAddButton()
                .checkAlertWithIncorrectEmailFormat());
    }
}
