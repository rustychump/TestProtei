import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private final String URL = "D:\\Projects\\TestsProtei\\src\\main\\resources\\qa-test.html"; //указать абсолютный путь до файла
    protected WebDriver driver;
    protected final String EMAIL = "test@protei.ru";
    protected final String PASSWORD = "test";
    protected final String INCORRECT_EMAIL_FORMAT = "testprotei.ru";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
