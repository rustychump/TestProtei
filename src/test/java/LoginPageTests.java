import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;

public class LoginPageTests extends BaseTest {

    private final String INCORRECT_EMAIL = "test1@protei.ru";
    private final String INCORRECT_PASSWORD = "test1";

    @DisplayName("Тест на проверку авторизации с корректными Email и паролем")
    @Test
    public void loginWithCorrectEmailAndPasswordTest(){
        Assert.assertTrue(new LoginPage(driver)
                .login(EMAIL, PASSWORD)
                .checkOpenFormPage());
    }

    @DisplayName("Тест на проверку авторизации с НЕкорректным Email и корректным паролем")
    @Test
    public void loginWithIncorrectEmail(){
        Assert.assertTrue(new LoginPage(driver)
                .setEmailField(INCORRECT_EMAIL)
                .setPasswordField(PASSWORD)
                .clickLoginButton()
                .checkAlertWithIncorrectEmailPassword());
    }

    @DisplayName("Тест на проверку авторизации с корректным Email и НЕкорректным паролем")
    @Test
    public void loginWithIncorrectPassword(){
        Assert.assertTrue(new LoginPage(driver)
                .setEmailField(EMAIL)
                .setPasswordField(INCORRECT_PASSWORD)
                .clickLoginButton()
                .checkAlertWithIncorrectEmailPassword());
    }

    @DisplayName("Тест на проверку авторизации с некорректным форматом Email")
    @Test
    public void loginWithIncorrectEmailFormat(){
        Assert.assertTrue(new LoginPage(driver)
                .setEmailField(INCORRECT_EMAIL_FORMAT)
                .setPasswordField(PASSWORD)
                .clickLoginButton()
                .checkAlertWithIncorrectEmailFormat());
    }

    @DisplayName("Тест на проверку авторизации без Email")
    @Test
    public void loginWithoutEmail(){
        Assert.assertTrue(new LoginPage(driver)
                .setEmailField("")
                .setPasswordField(PASSWORD)
                .clickLoginButton()
                .checkAlertWithIncorrectEmailFormat());
    }

    @DisplayName("Тест на проверку авторизации без пароля")
    @Test
    public void loginWithoutPassword(){
        Assert.assertTrue(new LoginPage(driver)
                .setEmailField(EMAIL)
                .setPasswordField("")
                .clickLoginButton()
                .checkAlertWithIncorrectEmailPassword());
    }

    @DisplayName("Тест на проверку авторизации без Email и пароля")
    @Test
    public void loginWithoutEmailAndPassword(){
        Assert.assertTrue(new LoginPage(driver)
                .setEmailField("")
                .setPasswordField("")
                .clickLoginButton()
                .checkAlertWithIncorrectEmailFormat());
    }
}