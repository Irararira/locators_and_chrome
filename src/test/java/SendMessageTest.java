import operations.Login;
import operations.WriteMessage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static operations.Constants.*;

public class SendMessageTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;

    @BeforeClass
    public static void setDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void sendMessage() {

        Login login = new Login(driver);
        login.open(URL)
                .consentForm(CONSENT,AGREE)
                .waitElementVisibleByCssSelector(BUTTON_EMAIL)
                .clickByCssSelector(BUTTON_EMAIL)
                .waitElementVisibleByCssSelector(SIGNIN)
                .clickByCssSelector(SIGNIN)
                .waitElementVisibleByCssSelector(FIELD_USERNAME)
                .sendKeyCssSelector(FIELD_USERNAME,LOGIN)
                .clickByCssSelector(BUTTON_NEXT)
                .waitElementVisibleByCssSelector(FIELD_PASSWORD)
                .sendKeyCssSelector(FIELD_PASSWORD,PASSWORD)
                .clickByCssSelector(BUTTON_NEXT)
                .waitElementVisibleByCssSelector(BUTTON_COMPOSE);


        WriteMessage writeMessage = new WriteMessage(driver);
        writeMessage.clickByCssSelector(BUTTON_COMPOSE)
                .clickByCssSelector(FIELD_TO)
                .enterValueByCssSelector(FIELD_TO, EMAIL)
                .enterValueByCssSelector(FIELD_SUBJECT, VALUE)
                .enterValueByCssSelector(FIELD_TEXT_MESSAGE, VALUE)
                .clickByCssSelector(BUTTON_SEND);

    }
}
