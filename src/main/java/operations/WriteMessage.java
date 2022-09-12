package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WriteMessage {

    private final WebDriver driver;

    public WriteMessage(WebDriver driver) {
        this.driver = driver;
    }

    public WriteMessage clickByCssSelector(String selector) {
        driver.findElement(By.cssSelector(selector)).click();
        return this;
    }

    public WriteMessage enterValueByCssSelector(String selector, String value) {
        driver.findElement(By.cssSelector(selector)).sendKeys(value);
        return this;
    }
}
