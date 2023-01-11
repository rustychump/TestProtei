import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.LoginPage;

@RunWith(Parameterized.class)
public class FormPageTestsWithParameters extends BaseTest{
    private final String testEmail;
    private final String name;
    private final String gender;
    private final String checkbox;
    private final String radioButton;

    public FormPageTestsWithParameters(String testEmail, String name, String gender, String checkbox, String radioButton) {
        this.testEmail = testEmail;
        this.name = name;
        this.gender = gender;
        this.checkbox = checkbox;
        this.radioButton = radioButton;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {"test1@protei.ru", "test1", "Мужской", "Вариант 1.1", "Вариант 2.1"},
                {"test2@protei.ru", "test2", "Женский", "Вариант 1.1" + "Вариант 1.2", "Вариант 2.2"},
                {"test3@protei.ru", "test3", "Мужской", "Вариант 1.2" , "Вариант 2.3"},
                {"test4@protei.ru", "test4", "Женский", "", "Вариант 2.1"},
                {"test5@protei.ru", "test5", "Мужской", "", "Вариант 2.2"},
                {"test6@protei.ru", "test6", "Женский", "", "Вариант 2.3"},
                {"test7@protei.ru", "test7", "Мужской", "Вариант 1.1" + "Вариант 1.2", "Вариант 2.1"},
                {"test8@protei.ru", "test8", "Женский", "Вариант 1.1" + "Вариант 1.2", "Вариант 2.3"},
                {"test9@protei.ru", "test9", "Мужской", "Вариант 1.1" + "Вариант 1.2", ""},
                {"test10@protei.ru", "test10", "Женский", "", ""},
        };
    }

    @Test
    public void addDataTest(){
        Assert.assertTrue(new LoginPage(driver)
                .login(EMAIL, PASSWORD)
                .setEmailField(testEmail)
                .setNameField(name)
                .selectGenderFromSelector(gender)
                .selectCheckbox(checkbox)
                .selectRadioButton(radioButton)
                .clickAddButton().checkAddData());
    }
}
